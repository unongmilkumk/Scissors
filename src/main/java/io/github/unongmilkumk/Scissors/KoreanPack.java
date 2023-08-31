package io.github.unongmilkumk.Scissors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    public static ArrayList<String> SNum = new ArrayList<>(Arrays.asList(
            "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"
    ));
    public static ArrayList<String> Num = new ArrayList<>(Arrays.asList(
            "", "만", "억", "조", "경", "해", "양", "자"
    ));
    public static ArrayList<String> Numm = new ArrayList<>(Arrays.asList(
            "자", "양", "해", "경", "조", "억", "만"
    ));
    public static String numberToKorean(int number) {
        String text = "";
        String nt = String.valueOf(number).replace("-", "");
        ArrayList<String> inte = new ArrayList<>();
        ArrayList<String> texts = new ArrayList<>();
        inte.add("");

        int a = 0;
        while (a <= nt.length() - 1) {
            int now = Integer.parseInt(String.valueOf(nt.toCharArray()[nt.length() - 1 - a]));
            if (inte.get(inte.size() - 1).equals("")) {
                inte.set(inte.size() - 1, String.valueOf(now));
            } else if (Integer.parseInt(inte.get(inte.size() - 1)) >= 1000) {
                inte.add("");
                inte.set(inte.size() - 1, String.valueOf(now));
            } else {
                inte.set(inte.size() - 1, now + inte.get(inte.size() - 1));
            }
            a += 1;
        }
        int b = 0;
        for (String integer : inte) {
            texts.add(Num.get(b));
            texts.add(smallNumberToKorean(Integer.parseInt(integer), b == 1));
            b++;
        }
        Collections.reverse(texts);
        for (String s : texts) {
            text += s;
        }
        if (number < 0) text = "마이너스 " + text;
        return text;
    }
    private static String smallNumberToKorean(int number, boolean isForMan) {
        String text = "";
        if (number == 0) {
            return "";
        }
        if (number == 1 && !isForMan) {
            return "일";
        }
        switch (getDigit(number, 4)) {
            case 1 -> text += "천";
            case 2, 3, 4, 5, 6, 7, 8, 9 -> {
                text += SNum.get(getDigit(number, 4) - 1);
                text += "천";
            }
        }
        switch (getDigit(number, 3)) {
            case 1 -> text += "백";
            case 2, 3, 4, 5, 6, 7, 8, 9 -> {
                text += SNum.get(getDigit(number, 3) - 1);
                text += "백";
            }
        }
        switch (getDigit(number, 2)) {
            case 1 -> text += "십";
            case 2, 3, 4, 5, 6, 7, 8, 9 -> {
                text += SNum.get(getDigit(number, 2) - 1);
                text += "십";
            }
        }
        switch (getDigit(number, 1)) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9 -> text += SNum.get(getDigit(number, 1) - 1);
        }
        return text;
    }
    public static int getDigit(int number, int a) {
        return (int) ((number / Math.pow(10, a-1)) % 10);
    }
    public static int koreanToNumber(String korean) {
        if (korean.equals("영") || korean.equals("마이너스 영")) return 0;
        int ret = 0;
        ArrayList<Integer> ints = new ArrayList<>();
        String kor = korean.replace("마이너스 ", "");
        for (String s : Numm) {
            if (!kor.contains(s)) continue;
            String string = kor.split(s)[0];
            if (s.equals("만") && string.equals("")) {
                ints.add(1);
                kor = kor.split("만")[1];
                continue;
            }
            kor = kor.split(s)[1];
            ints.add(smallKoreanToNumber(string));
        }

        ints.add(smallKoreanToNumber(kor));

        Collections.reverse(ints);

        int temp = 1;
        for (Integer anInt : ints) {
            ret += anInt * temp;
            temp *= 10000;
        }
        if (korean.contains("마이너스")) ret *= -1;
        return ret;
    }
    private static int smallKoreanToNumber(String korean) {
        String ret = "";
        ArrayList<Integer> integers = new ArrayList<>();
        String cc = "";
        for (char c : korean.toCharArray()) {
            switch (c) {
                case '천' -> {
                    if (cc.equals("")) {
                        integers.add(1);
                    } else {
                        integers.add(SNum.indexOf(cc) + 1);
                    }
                    cc = "";
                }
                case '백' -> {
                    if (!korean.contains("천")) integers.add(0);
                    if (cc.equals("")) {
                        integers.add(1);
                    } else {
                        integers.add(SNum.indexOf(cc) + 1);
                    }
                    cc = "";
                }
                case '십' -> {
                    if (!korean.contains("백")) {
                        if (!korean.contains("천")) integers.add(0);
                        integers.add(0);
                    }
                    if (cc.equals("")) {
                        integers.add(1);
                    } else {
                        integers.add(SNum.indexOf(cc) + 1);
                    }
                    cc = "";
                }
                default -> {
                    cc += c;
                }
            }
        }
        integers.add(SNum.indexOf(cc) + 1);
        for (Integer integer : integers) {
            ret += String.valueOf(integer);
        }
        return Integer.parseInt(ret);
    }
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
            String prev4 = it > 3 ? String.valueOf(text.toCharArray()[it - 4]) : "";
            String prev3 = it > 2 ? String.valueOf(text.toCharArray()[it - 3]) : "";
            String prev2 = it > 1 ? String.valueOf(text.toCharArray()[it - 2]) : "";
            String prev = it > 0 ? String.valueOf(text.toCharArray()[it - 1]) : "";
            String now = String.valueOf(text.toCharArray()[it]);
            if (JOONG.contains(now) && CHO.contains(prev)) {
                texts.get(texts.size() - 1).add(now);
            } else if (JONG.contains(now) && JOONG.contains(prev) && CHO.contains(prev2)) {
                texts.get(texts.size() - 1).add(now);
            } else if (JONG.contains(softMergeKorean(prev, now)) && JOONG.contains(prev2) && CHO.contains(prev3)) {
                texts.get(texts.size() - 1).add(now);
            } else if (JOONG.contains(softMergeKorean(prev, now)) && CHO.contains(prev2)) {
                texts.get(texts.size() - 1).add(now);
            } else if (JONG.contains(now) && JOONG.contains(softMergeKorean(prev2, prev)) && CHO.contains(prev3)) {
                texts.get(texts.size() - 1).add(now);
            } else if (JONG.contains(softMergeKorean(prev, now)) && JOONG.contains(softMergeKorean(prev3, prev2)) && CHO.contains(prev4)) {
                texts.get(texts.size() - 1).add(now);
            } else {
                texts.add(new ArrayList<>());
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
        return "nope";
    }

    private static char combine(int x1, int x2, int x3) {
        int x = x1 * 21 * 28 + x2 * 28 + x3;
        return (char) (x + 0xAC00);
    }
}