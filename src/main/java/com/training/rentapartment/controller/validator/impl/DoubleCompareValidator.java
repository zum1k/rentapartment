package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;

public class DoubleCompareValidator implements StringValidator {
    private final StringValidator numberValidator;
    private final int maxValue;
    private final int minValue;

    public DoubleCompareValidator(int MAX_VALUE, int MIN_VALUE) {
        this.numberValidator = new NumberFormatValidator();
        this.maxValue = MAX_VALUE;
        this.minValue = MIN_VALUE;
    }

    public DoubleCompareValidator(int MIN_VALUE) {
        this.numberValidator = new NumberFormatValidator();
        this.minValue = MIN_VALUE;
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
