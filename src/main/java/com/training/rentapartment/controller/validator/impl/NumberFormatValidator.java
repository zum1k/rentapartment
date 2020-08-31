package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;
import org.apache.commons.lang3.math.NumberUtils;

public class NumberFormatValidator implements StringValidator {
    private final StringValidator notNullValidator;

    public NumberFormatValidator() {
        this.notNullValidator = new NotNullValidator();
    }

    @Override
    public boolean validate(String value) {
        if (notNullValidator.validate(value)) {
            return NumberUtils.isParsable(value);
        }
        return false;
    }
}
