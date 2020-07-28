package com.training.rentapartment.model.specification.adverstisement.floor;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByFloorSpecification implements Specification {
    private final int floorValue;

    public AdvertisementByFloorSpecification(int floorValue) {
        this.floorValue = floorValue;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_FLOOR + " = ?";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(floorValue);
    }
}
