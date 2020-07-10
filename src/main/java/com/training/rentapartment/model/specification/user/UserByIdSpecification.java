package com.training.rentapartment.model.specification.user;

import com.training.rentapartment.model.SQLConstant;
import com.training.rentapartment.model.Specification;

import java.util.Arrays;
import java.util.List;

public class UserByIdSpecification implements Specification {
    private long id;

    public UserByIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SQLConstant.USER_ID + " = ?";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(id);
    }
}
