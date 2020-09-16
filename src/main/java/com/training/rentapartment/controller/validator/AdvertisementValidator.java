package com.training.rentapartment.controller.validator;

import com.training.rentapartment.controller.validator.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class AdvertisementValidator {
    private static final String PHONE_NUMBER_PATTERN = "^(\\+375)(29|25|44|33|17)(\\d{3})(\\d{2})(\\d{2})$";
    private static final String CITY_NAME_PATTERN = "^[a-zA-Zа-яА-Я]+(?:[\\s-][a-zA-Zа-яА-Я]+)*$";
    private static final String STREET_NAME_PATTERN = "^[a-zA-Zа-яА-Я]+(?:[\\s-][a-zA-Zа-яА-Я]+)*$";
    private static final int MAX_HOUSE_NUMBER = 300;
    private static final int MAX_HOUSE_INDEX = 10;
    private static final int DESCRIPTION_PATTERN_NUMBER = 400;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_FLOORS_NUMBER = 100;
    private static final int MAX_SQUARE_NUMBER = 1000;

    public boolean validateAdvertisement(HttpServletRequest request) {
        return validateParameters(request);
    }

    private boolean validateParameters(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        for (String key : parameters.keySet()) {
            String value = parameters.get(key)[0];
            if (!createValidator(key).validate(value)) {
                return false;
            }
        }
        return true;
    }

    private StringValidator createValidator(String parameterValue) {
        StringValidator validator = new NotNullValidator();
        switch (parameterValue) {
            case "cost":
            case "rooms":
                return new IntegerCompareValidator(MIN_NUMBER);
            case "floor":
                return new IntegerCompareValidator(MIN_NUMBER, MAX_FLOORS_NUMBER);
            case "square":
            case "living_square":
            case "kitchen_square":
                return new DoubleCompareValidator(MIN_NUMBER, MAX_SQUARE_NUMBER);
            case "phone":
                return new PatternValidator(PHONE_NUMBER_PATTERN);
            case "description":
                return new StringCompareValidator(DESCRIPTION_PATTERN_NUMBER);
            case "house_number":
                return new IntegerCompareValidator(MIN_NUMBER, MAX_HOUSE_NUMBER);
            case "house_index":
                return new IntegerCompareValidator(MIN_NUMBER, MAX_HOUSE_INDEX);
            case "city":
                return new PatternValidator(CITY_NAME_PATTERN);
            case "street":
                return new PatternValidator(STREET_NAME_PATTERN);
            case "owner":
                return new NotNullValidator();

        }
        return validator;
    }
}

