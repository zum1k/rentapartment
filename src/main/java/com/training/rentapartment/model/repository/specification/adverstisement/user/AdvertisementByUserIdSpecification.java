package com.training.rentapartment.model.repository.specification.adverstisement.user;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByUserIdSpecification implements Specification {
    private final IntegerSqlQueryParameter userId;

    public AdvertisementByUserIdSpecification(int userId) {
        this.userId = new IntegerSqlQueryParameter(userId);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.USER_ID + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(userId);
    }
}
