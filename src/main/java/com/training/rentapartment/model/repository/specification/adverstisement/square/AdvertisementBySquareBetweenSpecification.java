package com.training.rentapartment.model.repository.specification.adverstisement.square;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementBySquareBetweenSpecification implements Specification {
    private final IntegerSqlQueryParameter minValue;
    private final IntegerSqlQueryParameter maxValue;

    public AdvertisementBySquareBetweenSpecification(int minValue, int maxValue) {
        this.minValue = new IntegerSqlQueryParameter(minValue);
        this.maxValue = new IntegerSqlQueryParameter(maxValue);
    }

    @Override
    public String toSqlRequest() {
        return " AND " + SqlConstant.ADVERTISEMENT_SQUARE + ">="
                + " AND  " + SqlConstant.ADVERTISEMENT_SQUARE + " <= ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(minValue, maxValue);
    }
}
