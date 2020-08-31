package com.training.rentapartment.controller.validator.impl;

import com.training.rentapartment.controller.validator.StringValidator;

public class NotNullValidator implements StringValidator {
    @Override
    public boolean validate(String value) {
        return null==value;
    }
}
