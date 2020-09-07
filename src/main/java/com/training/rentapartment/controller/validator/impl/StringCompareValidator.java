package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;

public class StringCompareValidator implements StringValidator {
    private final StringValidator notNullValidator;
    private final int minValue;
    private final int maxValue;

    public StringCompareValidator(int minValue, int maxValue) {
        this.notNullValidator = new NotNullValidator();
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public StringCompareValidator(int maxValue) {
        this.notNullValidator = new NotNullValidator();
        this.maxValue = maxValue;
        this.minValue = 1;
    }

    @Override
    public boolean validate(String value) {
        if (notNullValidator.validate(value)) {
            return value.length() > minValue && value.length() <= maxValue;
        }
        return false;
    }
}
