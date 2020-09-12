package com.training.rentapartment.entity.dto;

import java.util.Map;

public class AdvertisementQueryDto {
    private Map<String, Number> queryParams;

    public AdvertisementQueryDto(Map<String, Number> queryParams) {
        this.queryParams = queryParams;
    }

    public Map<String, Number> getQueryParams() {
        return queryParams;
    }
}

