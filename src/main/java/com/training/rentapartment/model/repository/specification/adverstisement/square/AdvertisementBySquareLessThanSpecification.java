package com.training.rentapartment.model.repository.specification.adverstisement.square;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.DoubleSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementBySquareLessThanSpecification implements Specification {
    private final DoubleSqlQueryParameter maxValue;

    public AdvertisementBySquareLessThanSpecification(double maxValue) {
        this.maxValue = new DoubleSqlQueryParameter(maxValue);
    }

    @Override
    public String toSqlRequest() {
        return " AND " + SqlConstant.ADVERTISEMENT_SQUARE + " <= ? ";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(maxValue);
    }
}
