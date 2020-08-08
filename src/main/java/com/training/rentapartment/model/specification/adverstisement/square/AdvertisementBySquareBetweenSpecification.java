package com.training.rentapartment.model.specification.adverstisement.square;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

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
        return " WHERE " + SqlConstant.ADVERTISEMENT_SQUARE + " > ? "
                + " AND WHERE " + SqlConstant.ADVERTISEMENT_SQUARE + " < ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(minValue, maxValue);
    }
}
