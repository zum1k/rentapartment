package com.training.rentapartment.model.repository.specification.adverstisement.floor;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByFloorLessThanSpecification implements Specification {
    private final IntegerSqlQueryParameter maxValue;

    public AdvertisementByFloorLessThanSpecification(int maxValue) {
        this.maxValue = new IntegerSqlQueryParameter(maxValue);
    }

    @Override
    public String toSqlRequest() {
        return " AND " + SqlConstant.ADVERTISEMENT_FLOOR + " <= ? ";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(maxValue);
    }
}
