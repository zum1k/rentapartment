package com.training.rentapartment.model.specification.adverstisement.floor;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByFloorBetweenSpecification implements Specification {
    private final IntegerSqlQueryParameter lowerValue;
    private final IntegerSqlQueryParameter higherValue;

    public AdvertisementByFloorBetweenSpecification(int lowerValue, int higherValue) {
        this.lowerValue = new IntegerSqlQueryParameter(lowerValue);
        this.higherValue = new IntegerSqlQueryParameter(higherValue);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_FLOOR + " > ? " +
                " AND WHERE " + SqlConstant.ADVERTISEMENT_FLOOR + " < ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(lowerValue, higherValue);
    }
}
