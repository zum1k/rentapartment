package com.training.rentapartment.model.repository.specification.adverstisement.cost;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByCostOverThanSpecification implements Specification {
    private final IntegerSqlQueryParameter minValue;

    public AdvertisementByCostOverThanSpecification(int minValue) {
        this.minValue = new IntegerSqlQueryParameter(minValue);
    }

    @Override
    public String toSqlRequest() {
        return " AND " + SqlConstant.ADVERTISEMENT_COST + " >= ? ";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(minValue);
    }
}
