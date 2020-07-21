package com.training.rentapartment.model.specification.user;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class UserByIdSpecification implements Specification {
    private long id;

    public UserByIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.USER_ID + " = ?";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(id);
    }
}
