package com.training.rentapartment.model.repository.specification.adverstisement.floor;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

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
        return " AND " + SqlConstant.ADVERTISEMENT_FLOOR + " >= ? " +
                " AND " + SqlConstant.ADVERTISEMENT_FLOOR + " <= ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(lowerValue, higherValue);
    }
}
