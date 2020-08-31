package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;

public class IntegerCompareValidator implements StringValidator {
    private final StringValidator integerValidator;
    private final int maxValue;
    private final int minValue;

    public IntegerCompareValidator(int maxValue, int minValue) {
        this.integerValidator = new IntegerValidator();
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public IntegerCompareValidator(int minValue) {
        this.integerValidator = new IntegerValidator();
        this.minValue = minValue;
        this.maxValue = Integer.MAX_VALUE;
    }

    @Override
    public boolean validate(String value) {
        if (integerValidator.validate(value)) {
            int number = Integer.parseInt(value);
            return number >= minValue && number <= maxValue;
        }
        return false;
    }
}
