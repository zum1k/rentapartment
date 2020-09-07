package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;

public class DoubleCompareValidator implements StringValidator {
    private final StringValidator numberValidator;
    private final int maxValue;
    private final int minValue;

    public DoubleCompareValidator(int minValue, int maxValue) {
        this.numberValidator = new NumberFormatValidator();
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public DoubleCompareValidator(int minValue) {
        this.numberValidator = new NumberFormatValidator();
        this.minValue = minValue;
        this.maxValue = 1000000;
    }

    @Override
    public boolean validate(String value) {
        if (numberValidator.validate(value)) {
            double number = Double.parseDouble(value);
            return number >= minValue && number <= maxValue;
        }
        return false;
    }
}
