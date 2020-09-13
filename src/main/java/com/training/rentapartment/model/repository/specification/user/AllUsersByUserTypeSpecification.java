package com.training.rentapartment.model.repository.specification.user;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.StringSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AllUsersByUserTypeSpecification implements Specification {
    private final StringSqlQueryParameter userType;

    public AllUsersByUserTypeSpecification(String userType) {
        this.userType = new StringSqlQueryParameter(userType);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.USER_TYPE + " = ? ";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(userType);
    }
}
