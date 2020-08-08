package com.training.rentapartment.model.specification.adverstisement.cost;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByCostBetweenSpecification implements Specification {
    private final IntegerSqlQueryParameter minValue;
    private final IntegerSqlQueryParameter maxValue;

    public AdvertisementByCostBetweenSpecification(int minValue, int maxValue) {
        this.minValue = new IntegerSqlQueryParameter(minValue);
        this.maxValue = new IntegerSqlQueryParameter(maxValue);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_COST + " > ? "
                + " AND WHERE " + SqlConstant.ADVERTISEMENT_COST + " < ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(minValue, maxValue);
    }
}
