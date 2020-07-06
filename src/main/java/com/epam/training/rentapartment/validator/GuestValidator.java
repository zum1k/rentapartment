package com.epam.training.rentapartment.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuestValidator {
    static final String LOGIN_PATTERN = "^\\p{Alpha}[\\w]{5,14}$";
    static final String PASSWORD_PATTERN = "^[\\p{Alpha}\\d]{7,14}$ ";
    static final String EMAIL_PATTERN = "^([\\w\\-\\.]+)@([\\w\\-\\.]+)\\.(\\p{Alpha}{2,5})$";

    public static boolean validateLogin(String login, String password) { //TODO
//        if (login == null || password == null) {
//            return false;
//        } else {
//            boolean loginResult = matchPatternWithString(LOGIN_PATTERN, login);
//            boolean passwordResult = matchPatternWithString(PASSWORD_PATTERN, password);
//            return loginResult && passwordResult;
//        }
        return true;
    }

    public static boolean validateRegistration(String login, String password, String email) {
        if (login == null || password == null || email == null) {
            return false;
        } else {
            boolean loginMatcher = matchPatternWithString(LOGIN_PATTERN, login);
            boolean passwordMatcher = matchPatternWithString(PASSWORD_PATTERN, password);
            boolean emailMatcher = matchPatternWithString(EMAIL_PATTERN, email);
            return loginMatcher && passwordMatcher && emailMatcher;
        }
    }

    private static boolean matchPatternWithString(String pattern, String value) {
        Pattern loginPattern = Pattern.compile(pattern);
        Matcher loginMatcher = loginPattern.matcher(value);
        return loginMatcher.matches();
    }
}
