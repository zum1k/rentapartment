package com.training.rentapartment.controller.validator;

import com.training.rentapartment.controller.validator.impl.NotNullValidator;
import com.training.rentapartment.controller.validator.impl.PatternValidator;

public class GuestValidator {
    static final String LOGIN_PATTERN = "^\\p{Alpha}[\\w]{5,14}$";
    static final String PASSWORD_PATTERN = "^[\\p{Alpha}\\d]{7,14}$";
    static final String EMAIL_PATTERN = "^([\\w\\-\\.]+)@([\\w\\-\\.]+)\\.(\\p{Alpha}{2,5})$";

    public boolean validateLogin(String login, String password) {
        PatternValidator loginValidator = new PatternValidator(LOGIN_PATTERN);
        PatternValidator passwordValidator = new PatternValidator(PASSWORD_PATTERN);
        return loginValidator.validate(login) && passwordValidator.validate(password);
    }

    public boolean validateRegistration(String login, String password, String email) {
        PatternValidator loginValidator = new PatternValidator(LOGIN_PATTERN);
        PatternValidator passwordValidator = new PatternValidator(PASSWORD_PATTERN);
        PatternValidator emailValidator = new PatternValidator(EMAIL_PATTERN);
        return loginValidator.validate(login) && passwordValidator.validate(password) && emailValidator.validate(email);

    }
}
