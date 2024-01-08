package io.github.unongmilkumk.Scissors.website;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WebsiteAPI {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(3000), 0);
        String html = readFile("server/index.html");
        String login = readFile("server/login.html");

        UserRepository.saveUser("limitation", "conquer");

        makeRouting(server, "/", (exchange, sessionToken) -> {
            // Handle GET request for '/'
            String username = AuthService.getUsernameByToken(sessionToken);
            if (username != null) {
                // User is authenticated, handle the request
                // ...
                sendHTML(exchange, html);
            } else {
                // User is not authenticated, redirect to login page
                goToRouting(exchange, "/login");
            }
        }, (exchange, sessionToken) -> {
            // Handle POST request for '/'
            // Check if the user is authenticated using 'sessionToken'
            String username = AuthService.getUsernameByToken(sessionToken);
            if (username != null) {
                // User is authenticated, handle the request
                // ...
                sendHTML(exchange, html);
            } else {
                // User is not authenticated, redirect to login page
                goToRouting(exchange, "/login");
            }
        });

        makeRouting(server, "/login", (exchange, sessionToken) -> {
            // Handle GET request for '/login'
            sendHTML(exchange, login);
        }, (exchange, sessionToken) -> {
            // Handle POST request for '/login'
            String formData = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))
                    .lines().reduce("", (acc, line) -> acc + line);

            System.out.println("Received FormData for '/login': " + formData);

            String id = formData.substring(formData.indexOf("id=") + 3, formData.indexOf("&"));
            String password = formData.substring(formData.indexOf("password=") + 9, formData.indexOf("&"));

            String sessionToken1 = AuthService.authenticateUser(id, password);

            if (sessionToken1 != null) {
                exchange.getResponseHeaders().add("Set-Cookie", "sessionToken=" + sessionToken1);
                sendHTML(exchange, html);
            } else {
                // Handle authentication failure
                sendHTML(exchange, login);
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Server is running on port 3000. Open http://localhost:3000 in your browser.");
    }

    private static void makeRouting(HttpServer server, String path, RoutingHandler getRequest, RoutingHandler postRequest) {
        server.createContext(path, exchange -> {
            String sessionToken = getSessionTokenFromRequest(exchange);

            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                postRequest.handle(exchange, sessionToken);
            } else {
                getRequest.handle(exchange, sessionToken);
            }
        });
    }

    private static String getSessionTokenFromRequest(HttpExchange exchange) {
        List<String> headers = exchange.getRequestHeaders().get("Cookie");
        if (headers != null) {
            for (String header : headers) {
                for (String cookie : header.split(";")) {
                    String trimmedCookie = cookie.trim();
                    if (trimmedCookie.startsWith("sessionToken=")) {
                        return trimmedCookie.substring("sessionToken=".length());
                    }
                }
            }
        }
        return null;
    }

    private static void sendHTML(HttpExchange exchange, String html) throws IOException {
        exchange.sendResponseHeaders(200, html.length());
        try (OutputStream os = exchange.getResponseBody();
             OutputStreamWriter writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            writer.write(html);
        }
    }

    private static void goToRouting(HttpExchange exchange, String targetRoute) {
        exchange.getResponseHeaders().add("Location", targetRoute);
        try {
            exchange.sendResponseHeaders(302, -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        exchange.close();
    }

    private static String readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }

    interface RoutingHandler {
        void handle(HttpExchange exchange, String sessionToken) throws IOException;
    }
}

record User(int id, String username, String hashedPassword, String salt) {

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getSalt() {
        return salt;
    }
}

class UserRepository {
    private static final List<User> users = new ArrayList<>();
    private static int userIdCounter = 1;

    private static final File databaseFile = new File("database/user_database.txt");

    static {
        if (databaseFile.exists()) {
            loadUsersFromFile();
        }
    }

    public static void saveUser(String username, String password) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        User newUser = new User(userIdCounter++, username, hashedPassword, salt);
        users.add(newUser);
        saveUsersToFile();
    }

    public static User getUserByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    private static String generateSalt() {
        byte[] saltBytes = new byte[16];
        new SecureRandom().nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    private static String hashPassword(String password, String salt) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            String saltedPassword = password + salt;
            byte[] hashedBytes = messageDigest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void saveUsersToFile() {
        String jsonString = buildJsonString(users);
        try {
            FileWriter writer = new FileWriter(databaseFile);
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadUsersFromFile() {
        try {
            String jsonString = new String(Files.readAllBytes(databaseFile.toPath()));
            users.clear();
            users.addAll(parseJsonString(jsonString));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String buildJsonString(List<User> users) {
        return users.stream()
                .map(user -> String.format("{\"id\":%d,\"username\":\"%s\",\"hashedPassword\":\"%s\",\"salt\":\"%s\"}",
                        user.getId(), user.getUsername(), user.getHashedPassword(), user.getSalt()))
                .collect(Collectors.joining(","));
    }

    private static List<User> parseJsonString(String jsonString) {
        List<User> userList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{\"id\":(\\d+),\"username\":\"([^\"]+)\",\"hashedPassword\":\"([^\"]+)\",\"salt\":\"([^\"]+)\"}");
        Matcher matcher = pattern.matcher(jsonString);
        while (matcher.find()) {
            int id = Integer.parseInt(matcher.group(1));
            String username = matcher.group(2);
            String hashedPassword = matcher.group(3);
            String salt = matcher.group(4);
            userList.add(new User(id, username, hashedPassword, salt));
        }
        return userList;
    }
}

class AuthService {
    private static final Map<String, String> sessionTokens = new HashMap<>();

    public static String authenticateUser(String username, String password) {
        User user = UserRepository.getUserByUsername(username);
        if (user != null && user.getHashedPassword().equals(hashPassword(password, user.getSalt()))) {
            String sessionToken = generateSessionToken();
            sessionTokens.put(sessionToken, username);
            return sessionToken;
        } else {
            return null;
        }
    }

    private static String hashPassword(String password, String salt) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            String saltedPassword = password + salt;
            byte[] hashedBytes = messageDigest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUsernameByToken(String sessionToken) {
        return sessionTokens.get(sessionToken);
    }

    private static String generateSessionToken() {
        return java.util.UUID.randomUUID().toString();
    }
}
