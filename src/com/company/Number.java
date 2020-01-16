package com.company;

public class Number {
    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isSimple (int number) {
        if (number <= 1) return false;
        if (number == 2) return  true;
        if (number % 2 == 0) return  false;
        for (int i = 2; i < (number / 2); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return  true;
    }
}
