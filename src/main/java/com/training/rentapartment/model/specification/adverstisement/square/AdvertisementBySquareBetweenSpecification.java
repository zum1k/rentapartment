package com.training.rentapartment.model.specification.adverstisement.square;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class AdvertisementBySquareBetweenSpecification implements Specification {
    private final int minValue;
    private final int maxValue;

    public AdvertisementBySquareBetweenSpecification(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_SQUARE + " > ? "
                + " AND WHERE " + SqlConstant.ADVERTISEMENT_SQUARE + " < ?";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(minValue, maxValue);
    }
}
