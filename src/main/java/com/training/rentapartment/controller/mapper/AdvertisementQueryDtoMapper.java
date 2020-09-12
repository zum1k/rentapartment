package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.validator.StringValidator;
import com.training.rentapartment.controller.validator.impl.NotNullValidator;
import com.training.rentapartment.controller.validator.impl.PatternValidator;
import com.training.rentapartment.entity.dto.AdvertisementQueryDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvertisementQueryDtoMapper implements EntityMapper<AdvertisementQueryDto> {
    private static final String PATTERN_VALUE = "";
    @Override
    public AdvertisementQueryDto toEntity(HttpServletRequest request) throws IOException, ServletException {
        Map<String, Number> queryParams = new HashMap<>();
        Map<String, String[]> parameters = request.getParameterMap();
        StringValidator validator = new PatternValidator(PATTERN_VALUE);
        for (String key : parameters.keySet()) {
            String value = parameters.get(key)[0];
            switch (key) {
                case HttpRequestParameters.SQUARE_MIN:
                case HttpRequestParameters.SQUARE_MAX:
                    if(!validator.validate(value)) {
                        queryParams.put(key, createDouble(value));
                        break;
                    }
                    break;
                case HttpRequestParameters.COST_MIN:
                case HttpRequestParameters.COST_MAX:
                case HttpRequestParameters.ROOM:
                case HttpRequestParameters.ROOM_MIN:
                case HttpRequestParameters.ROOM_MAX:
                case HttpRequestParameters.FLOOR:
                case HttpRequestParameters.FLOOR_MIN:
                case HttpRequestParameters.FLOOR_MAX:
                    if(!validator.validate(value)) {
                        queryParams.put(key, createInteger(value));
                        break;
                    }
                    break;
            }
        }
        return new AdvertisementQueryDto(queryParams);
    }

    @Override
    public List<AdvertisementQueryDto> toEntityList(HttpServletRequest request) throws IOException, ServletException {
        return null;
    }

    private Integer createInteger(String parameterValue) {
        NotNullValidator notNullValidator = new NotNullValidator();
        return notNullValidator.validate(parameterValue) ? Integer.parseInt(parameterValue) : null;
    }

    private Double createDouble(String parameterValue) {
        NotNullValidator notNullValidator = new NotNullValidator();
        return notNullValidator.validate(parameterValue) ? Double.parseDouble(parameterValue) : null;
    }
}
