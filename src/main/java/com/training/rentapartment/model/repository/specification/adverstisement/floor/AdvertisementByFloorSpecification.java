package com.training.rentapartment.model.repository.specification.adverstisement.floor;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByFloorSpecification implements Specification {
    private final IntegerSqlQueryParameter floorValue;

    public AdvertisementByFloorSpecification(int floorValue) {
        this.floorValue = new IntegerSqlQueryParameter(floorValue);
    }
    @Override
    public String toSqlRequest() {
        return " AND " + SqlConstant.ADVERTISEMENT_FLOOR + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(floorValue);
    }
}
