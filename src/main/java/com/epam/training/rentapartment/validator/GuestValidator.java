package com.epam.training.rentapartment.validator;

public class GuestValidator {
    static final String LOGIN_PATTERN = "^\\p{Alpha}[\\w]{7,14}$";
    static final String PASSWORD_PATTERN = "^[\\p{Alpha}\\d]{9,14}$ ";
    static final String EMAIL_PATTERN = "^([\\w\\-\\.]+)@([\\w\\-\\.]+)\\.(\\p{Alpha}{2,5})$";

    public static boolean validateLogin(String login, String password) {
        if (login == null || password == null) {
            return false;
        } else {
            boolean loginMatcher = login.matches(LOGIN_PATTERN);
            boolean passwordMatcher = password.matches(PASSWORD_PATTERN);
            return loginMatcher && passwordMatcher;
        }
    }

    public static boolean validateRegistration(String login, String password, String email) {
        if (login == null || password == null || email == null) {
            return false;
        } else {
            boolean loginMatcher = login.matches(LOGIN_PATTERN);
            boolean passwordMatcher = password.matches(PASSWORD_PATTERN);
            boolean emailMatcher = email.matches(EMAIL_PATTERN);
            return loginMatcher && passwordMatcher && emailMatcher;
        }
    }
}
