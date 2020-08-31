package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidator implements StringValidator {
    private final StringValidator notNullValidator;
    private final String pattern;

    public PatternValidator(String pattern) {
        this.notNullValidator = new NotNullValidator();
        this.pattern = pattern;
    }

    @Override
    public boolean validate(String value) {
        if(notNullValidator.validate(value)) {
            return matchPatternWithString(pattern, value);
        }
        return false;
    }
    private static boolean matchPatternWithString(String pattern, String value) {
        Pattern valuePattern = Pattern.compile(pattern);
        Matcher valueMatcher = valuePattern.matcher(value);
        return valueMatcher.matches();
    }
}
