package com.training.rentapartment.model.specification.adverstisement.floor;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByFloorSpecification implements Specification {
    private final IntegerSqlQueryParameter floorValue;

    public AdvertisementByFloorSpecification(int floorValue) {
        this.floorValue = new IntegerSqlQueryParameter(floorValue);
    }
    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_FLOOR + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(floorValue);
    }
}
