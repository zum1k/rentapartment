package com.training.rentapartment.model.repository.specification.adverstisement;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByLimitAndOffsetSpecification implements Specification {
    private final IntegerSqlQueryParameter advertisementOffset;
    private final IntegerSqlQueryParameter advertisementLimit;

    public AdvertisementByLimitAndOffsetSpecification(int advertisementOffset, int advertisementLimit) {
        this.advertisementOffset = new IntegerSqlQueryParameter(advertisementOffset);
        this.advertisementLimit = new IntegerSqlQueryParameter(advertisementLimit);
    }

    @Override
    public String toSqlRequest() {
        return " LIMIT ? OFFSET ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(advertisementLimit, advertisementOffset);
    }
}
