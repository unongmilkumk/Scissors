package io.github.unongmilkumk.Scissors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KoreanPack {
    public static ArrayList<String> koreans = new ArrayList<>(Arrays.asList("ㅂ", "ㅈ", "ㄷ", "ㄱ", "ㅅ", "ㅛ", "ㅕ", "ㅑ", "ㅐ", "ㅔ", "ㅁ", "ㄴ", "ㅇ", "ㄹ", "ㅎ", "ㅗ", "ㅓ", "ㅏ",
            "ㅣ", "ㅋ", "ㅌ", "ㅊ", "ㅍ", "ㅠ", "ㅜ", "ㅡ", "ㄳ", "ㄵ", "ㄶ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅄ", "ㅘ", "ㅙ", "ㅚ", "ㅝ", "ㅞ", "ㅟ", "ㅢ",
            "ㄲ", "ㄸ", "ㅃ", "ㅆ", "ㅉ", "ㅖ", "ㅒ"));

    public static ArrayList<String> englishes = new ArrayList<>(Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k",
            "l", "z", "x", "c", "v", "b", "n", "m", "rt", "sw", "sg", "fr", "fa", "fq", "ft", "fx", "fv", "fg", "qt", "hk", "ho", "hl", "nj", "np", "nl", "ml",
            "R", "E", "Q", "T", "W", "P", "O"));

    public static ArrayList<String> CHO = new ArrayList<>(Arrays.asList(
            "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ",
            "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"
    ));
    public static ArrayList<String> JOONG = new ArrayList<>(Arrays.asList(
            "ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ",
            "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"
    ));
    public static ArrayList<String> JONG = new ArrayList<>(Arrays.asList(
            "", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ",
            "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"
    ));
    public static String mergeLanguage(String string) {
        String text = "";
        for (int ind = 0; ind <= string.length() - 1; ind++) {
            char i = string.toCharArray()[ind];
            if ((int) i >= 0xAC00 && (int) i <= 0xD7AF) {
                text += koreanToEnglish(String.valueOf(i));
            } else if (((int) i >= 0x0041 && (int) i <= 0x005A) || ((int) i >= 0x0061 && (int) i <= 0x007A)) {
                text += englishToKorean(String.valueOf(i));
            } else {
                text += i;
            }
        }
        return joinKorean(text);
    }
    public static String koreanToEnglish(String string) {
        String text = splitKorean(string);
        for (int i = 0; i <= koreans.size() - 1; i++) {
            if (text.contains(koreans.get(i))) {
                text = text.replace(koreans.get(i), englishes.get(i));
            }
        }
        return text;
    }

    public static String englishToKorean(String string) {
        String text = string;
        for (int i = 0; i <= koreans.size() - 1; i++) {
            if (text.contains(englishes.get(i))) {
                text = text.replace(englishes.get(i), koreans.get(i));
            }
        }
        return joinKorean(text);
    }

    public static String splitKorean(String string) {
        StringBuilder text = new StringBuilder();
        for (char element : string.toCharArray()) {
            var uniVal = element;

            if ((int) uniVal >= 0xAC00) {
                uniVal = (char) ((int) uniVal - 0xAC00);
                char cho = (char) ((int) uniVal / 28 / 21);
                char joong = (char) ((int) uniVal / 28 % 21);
                char jong = (char) ((int) uniVal % 28);
                text.append(CHO.get(cho)).append(JOONG.get(joong)).append(JONG.get(jong));
            } else {
                text.append(uniVal);
            }
        }
        return text.toString();
    }

    public static String joinKorean(String text) {
        ArrayList<ArrayList<String>> texts = new ArrayList<>();
        for (int it = 0; it <= text.toCharArray().length - 1; it++) {
            String now = String.valueOf(text.toCharArray()[it]);
            String next;
            if (text.length() - 1 != it) next = String.valueOf(text.toCharArray()[it + 1]);
            else next = "";
            if (!CHO.contains(now) && !JOONG.contains(now) && !JONG.contains(now)) {
                texts.add(new ArrayList<>(List.of(now)));
                texts.add(new ArrayList<>());
            } else if (JOONG.contains(next) && CHO.contains(now)) {
                texts.add(new ArrayList<>(List.of(now)));
            } else {
                if (texts.isEmpty()) texts.add(new ArrayList<>(List.of()));
                texts.get(texts.size() - 1).add(now);
            }
        }
        var tt = new Object() {
            String t = "";
        };
        texts.forEach((it) -> {
            switch (it.size()) {
                case 1 -> tt.t += it.get(0);
                case 2 -> tt.t += combine(CHO.indexOf(it.get(0)), JOONG.indexOf(it.get(1)), 0);
                case 3 ->{
                    if (JOONG.contains(it.get(2))) {
                        tt.t += combine(CHO.indexOf(it.get(0)), JOONG.indexOf(softMergeKorean(it.get(1), it.get(2))), 0);
                    } else {
                        tt.t += combine(CHO.indexOf(it.get(0)), JOONG.indexOf(it.get(1)), JONG.indexOf(it.get(2)));
                    }
                }
                case 4 -> tt.t += JOONG.contains(it.get(2)) ? combine(CHO.indexOf(it.get(0)), JOONG.indexOf(softMergeKorean(it.get(1), it.get(2))), JONG.indexOf(it.get(3)))
                        : combine(CHO.indexOf(it.get(0)), JOONG.indexOf(it.get(1)), JONG.indexOf(softMergeKorean(it.get(2), it.get(3))));
                case 5 -> tt.t += combine(CHO.indexOf(it.get(0)), JOONG.indexOf(softMergeKorean(it.get(1), it.get(2))), JONG.indexOf(softMergeKorean(it.get(3), it.get(4))));
            }
        });
        return tt.t;
    }

    public static String softMergeKorean(String a, String b) {
        if (a.equals("ㄱ") && b.equals("ㅅ")) return "ㄳ";
        if (a.equals("ㄴ") && b.equals("ㅈ")) return "ㄵ";
        if (a.equals("ㄴ") && b.equals("ㅎ")) return "ㄶ";
        if (a.equals("ㄹ") && b.equals("ㄱ")) return "ㄺ";
        if (a.equals("ㄹ") && b.equals("ㅁ")) return "ㄻ";
        if (a.equals("ㄹ") && b.equals("ㅂ")) return "ㄼ";
        if (a.equals("ㄹ") && b.equals("ㅅ")) return "ㄽ";
        if (a.equals("ㄹ") && b.equals("ㅌ")) return "ㄾ";
        if (a.equals("ㄹ") && b.equals("ㅍ")) return "ㄿ";
        if (a.equals("ㄹ") && b.equals("ㅎ")) return "ㅀ";
        if (a.equals("ㅂ") && b.equals("ㅅ")) return "ㅄ";
        if (a.equals("ㅗ") && b.equals("ㅏ")) return "ㅘ";
        if (a.equals("ㅗ") && b.equals("ㅐ")) return "ㅙ";
        if (a.equals("ㅗ") && b.equals("ㅣ")) return "ㅚ";
        if (a.equals("ㅜ") && b.equals("ㅓ")) return "ㅝ";
        if (a.equals("ㅜ") && b.equals("ㅔ")) return "ㅞ";
        if (a.equals("ㅜ") && b.equals("ㅣ")) return "ㅟ";
        if (a.equals("ㅡ") && b.equals("ㅣ")) return "ㅢ";
        return "?";
    }

    private static char combine(int x1, int x2, int x3) {
        int x = x1 * 21 * 28 + x2 * 28 + x3;
        return (char) (x + 0xAC00);
    }
}
