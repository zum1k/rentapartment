package com.epam.training.rentapartment.specification.impl.user;

import com.epam.training.rentapartment.entity.User;
import com.epam.training.rentapartment.specification.Specification;

import java.util.List;

public class UserByLoginSpecification implements Specification {
    private String requestLogin;

    @Override
    public String toSqlRequest() {
        return null;
    }

    @Override
    public List<String> receiveParameters() {
        return null;
    }
}
