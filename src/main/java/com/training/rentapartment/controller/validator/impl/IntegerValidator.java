package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;
import org.apache.commons.lang3.math.NumberUtils;

public class IntegerValidator implements StringValidator {
    private final StringValidator numberFormatValidator;

    public IntegerValidator() {
        this.numberFormatValidator = new NumberFormatValidator();
    }

    @Override
    public boolean validate(String value) {
        if(numberFormatValidator.validate(value)) {
            return NumberUtils.isDigits(value);
        }
        return false;
    }
}
