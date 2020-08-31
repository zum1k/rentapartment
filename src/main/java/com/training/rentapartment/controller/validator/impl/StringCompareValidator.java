package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;

public class StringCompareValidator implements StringValidator {
    private final StringValidator notNullValidator;
    private final int MAX_VALUE;
    private final int MIN_VALUE;

    public StringCompareValidator(int MAX_VALUE, int MIN_VALUE) {
        this.notNullValidator = new NotNullValidator();
        this.MAX_VALUE = MAX_VALUE;
        this.MIN_VALUE = MIN_VALUE;
    }

    public StringCompareValidator(int MIN_VALUE) {
        this.notNullValidator = new NotNullValidator();
        this.MIN_VALUE = MIN_VALUE;
        this.MAX_VALUE = 1000000;
    }

    @Override
    public boolean validate(String value) {
        if (notNullValidator.validate(value)) {
            return value.length() > MIN_VALUE && value.length() <= MAX_VALUE;
        }
        return false;
    }
}
