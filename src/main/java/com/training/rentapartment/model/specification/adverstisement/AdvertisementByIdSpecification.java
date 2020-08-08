package com.training.rentapartment.model.specification.adverstisement;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByIdSpecification implements Specification {
    private final IntegerSqlQueryParameter adId;

    public AdvertisementByIdSpecification(int adId) {
        this.adId = new IntegerSqlQueryParameter(adId);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_ID + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(adId);
    }
}
