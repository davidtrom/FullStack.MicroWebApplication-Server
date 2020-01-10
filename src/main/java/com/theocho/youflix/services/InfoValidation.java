package com.theocho.youflix.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoValidation {

    public static Boolean between6And20Chars(String input) {
        return input.length() > 5 && input.length() < 21;
    }

    public static Boolean upperAndLowercaseChars(String input) {
        return input.matches(".*[a-z].*") && input.matches(".*[A-Z].*");
    }

    public static Boolean containsNumber(String input) {
        return input.matches(".*[0-9].*");
    }

    public static Boolean doesNotContainSpace(String input) {
        return !input.contains(" ");
    }

    public static Boolean validEmail(String emailAddress) {
        String regex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches();
    }

    public static Boolean validUsername(String username) {
        return (between6And20Chars(username)    &&
                doesNotContainSpace(username));
    }

    public static Boolean validPassword(String password) {
        return (between6And20Chars(password)    &&
                upperAndLowercaseChars(password)&&
                containsNumber(password)        &&
                doesNotContainSpace(password));
    }


}
