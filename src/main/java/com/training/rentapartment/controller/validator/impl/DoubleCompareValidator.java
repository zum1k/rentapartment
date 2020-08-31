package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;

public class DoubleCompareValidator implements StringValidator {
    private final StringValidator numberValidator;
    private final int MAX_VALUE;
    private final int MIN_VALUE;

    public DoubleCompareValidator(int MAX_VALUE, int MIN_VALUE) {
        this.numberValidator = new NumberFormatValidator();
        this.MAX_VALUE = MAX_VALUE;
        this.MIN_VALUE = MIN_VALUE;
    }

    public DoubleCompareValidator(int MIN_VALUE) {
        this.numberValidator = new NumberFormatValidator();
        this.MIN_VALUE = MIN_VALUE;
        this.MAX_VALUE = 1000000;
    }

    @Override
    public boolean validate(String value) {
        if (numberValidator.validate(value)) {
            double number = Double.parseDouble(value);
            return number >= MIN_VALUE && number <= MAX_VALUE;
        }
        return false;
    }
}
