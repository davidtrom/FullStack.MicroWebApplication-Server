package com.theocho.youflix.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoValidation {

    public static Boolean between8And20Chars(String input) {
        return input.length() > 7 && input.length() < 21;
    }

    public static Boolean upperAndLowercaseChars(String input) {
        return input.equals(input.toLowerCase()) || input.equals(input.toUpperCase());
    }

    public static Boolean noSpecialCharacters(String input) {

        //Checks at least one char is not alpha numeric
        return !input.matches("[=;:*/+()^\\[\\]{}|,]*");
    }

    public static Boolean containsNumber(String input) {
        return input.matches(".*[0-9].*");
    }

    public static Boolean doesNotContainSpace(String input) {
        return !input.contains(" ");
    }

    public static Boolean containsAlphaNumeric(String inputName) {
        return inputName.matches("[A-Za-z0-9 ]*");
    }

    public static Boolean isEmailValid(String emailAddress) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches();
    }


}
