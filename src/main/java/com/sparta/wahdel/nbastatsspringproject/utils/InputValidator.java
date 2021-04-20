package com.sparta.wahdel.nbastatsspringproject.utils;

public class InputValidator {

    public static boolean isValidUsername(String username) {
        return username.length() >= 5 && !containsSpecialChar(username) && !containsWhiteSpace(username);
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 8 && containsSpecialChar(password) && !containsWhiteSpace(password);
    }

    private static boolean isLetter(char character) {
        return Character.isLetter(character);
    }

    private static boolean isDigit(char character) {
        return Character.isDigit(character);
    }

    private static boolean containsNumber(String input) {
        return input.matches(".*\\d.*");
    }

    private static boolean containsSpecialChar(String input) {
        return !input.matches("[a-zA-Z0-9]*");
    }

    private static boolean containsWhiteSpace(String input) {
        return input.contains("\t") || input.contains(" ");
    }
}
