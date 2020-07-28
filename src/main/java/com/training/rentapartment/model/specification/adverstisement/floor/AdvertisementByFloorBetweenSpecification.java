package com.training.rentapartment.model.specification.adverstisement.floor;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByFloorBetweenSpecification implements Specification {
    private final int lowerValue;
    private final int higherValue;

    public AdvertisementByFloorBetweenSpecification(int lowerValue, int higherValue) {
        this.lowerValue = lowerValue;
        this.higherValue = higherValue;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_FLOOR + " > ? " +
                " AND WHERE " + SqlConstant.ADVERTISEMENT_FLOOR + " < ?";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(lowerValue, higherValue);
    }
}
