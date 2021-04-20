package com.sparta.wahdel.nbastatsspringproject.utils;

public class InputValidator {

    public static boolean isValidUsername(String username) {
        return username.length() >= 5 &&
                containsLetter(username) &&
                !containsSpecialChar(username) &&
                !containsWhiteSpace(username);
    }

    public static boolean isValidPassword(String password) {
        boolean uc = containsUppercase(password);
        boolean lc = containsLowerCase(password);
        boolean num = containsNumber(password);
        boolean sc = containsSpecialChar(password);
        boolean ws = !containsWhiteSpace(password);

        return password.length() >= 8 &&
                containsUppercase(password) &&
                containsLowerCase(password) &&
                containsNumber(password) &&
                containsSpecialChar(password) &&
                !containsWhiteSpace(password);
    }

    private static boolean containsLetter(String input) {
        return containsLowerCase(input) || containsUppercase(input);
    }

    private static boolean containsUppercase(String input) {
        return input.matches(".*[A-Z].*");
    }

    private static boolean containsLowerCase(String input) {
        return input.matches(".*[a-z].*");
    }

    private static boolean containsNumber(String input) {
        return input.matches(".*[0-9].*");
    }

    private static boolean containsSpecialChar(String input) {
        return !input.matches("[a-zA-Z0-9]*");
    }

    private static boolean containsWhiteSpace(String input) {
        return input.contains("\t") || input.contains(" ");
    }
}
