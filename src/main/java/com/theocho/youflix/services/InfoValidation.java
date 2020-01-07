package com.theocho.youflix.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoValidation {

    private static Boolean between6And20Chars(String input) {
        return input.length() > 5 && input.length() < 21;
    }

    private static Boolean upperAndLowercaseChars(String input) {
        return input.equals(input.toLowerCase()) || input.equals(input.toUpperCase());
    }

    private static Boolean noSpecialCharacters(String input) {
        return !input.matches("[=;:*/+()^\\[\\]{}|,]*");
    }

    private static Boolean containsNumber(String input) {
        return input.matches(".*[0-9].*");
    }

    private static Boolean doesNotContainSpace(String input) {
        return !input.contains(" ");
    }

    private static Boolean containsAlphaNumeric(String inputName) {
        return inputName.matches("[A-Za-z0-9 ]*");
    }

    public static Boolean validEmail(String emailAddress) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches();
    }

    public static Boolean validUsername(String username) {
        return (between6And20Chars(username)    &&
                noSpecialCharacters(username)   &&
                doesNotContainSpace(username)   &&
                containsAlphaNumeric(username));
    }

    public static Boolean validPassword(String password) {
        return (between6And20Chars(password)    &&
                upperAndLowercaseChars(password)&&
                noSpecialCharacters(password)   &&
                containsNumber(password)        &&
                doesNotContainSpace(password)   &&
                containsAlphaNumeric(password));
    }


}
