package com.training.rentapartment.controller.validator;

import com.training.rentapartment.controller.validator.impl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class AdvertisementQueryDtoValidator {
    private static final String PATTERN_VALUE = "";
    private static final int MIN_VALUE = 0;
    private static final int MAX_ROOM_VALUE = 6;
    private static final int MAX_SQUARE_NUMBER = 1000;
    private static final int MAX_FLOORS_NUMBER = 100;
    private static final int MAX_COST_VALUE = 2000000;
    public boolean validateAdvertisementQueryDto(HttpServletRequest request){
        return validateParameters(request);
    }

    private boolean validateParameters(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();
        for (String key : parameters.keySet()) {
            String value = parameters.get(key)[0];
            StringValidator validator = new PatternValidator(PATTERN_VALUE);
            if(validator.validate(value)){
                continue;
            }
            if (!createValidator(key).validate(value)) {
                return false;
            }
        }
        return true;
    }
    private StringValidator createValidator(String parameterValue) {
        StringValidator validator = new NotNullValidator();
        switch (parameterValue) {
            case "min_cost":
            case "max_cost":
                return new IntegerCompareValidator(MIN_VALUE, MAX_COST_VALUE);
            case "min_square":
            case "max_square":
                return new DoubleCompareValidator(MIN_VALUE, MAX_SQUARE_NUMBER);
            case "room":
            case "min_room":
            case "max_room":
                return new IntegerCompareValidator(MIN_VALUE,MAX_ROOM_VALUE);
            case "floor":
            case "min_floor":
            case "max_floor":
                return new IntegerCompareValidator(MIN_VALUE, MAX_FLOORS_NUMBER);
            case "owner":
                return new NotNullValidator();
        }
        return validator;
    }
}
