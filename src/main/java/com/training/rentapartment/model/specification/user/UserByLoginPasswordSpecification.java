package com.training.rentapartment.model.specification.user;

import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.Specification;

import java.util.Arrays;
import java.util.List;

public class UserByLoginPasswordSpecification implements Specification {
    private final String login;
    private final String password;

    public UserByLoginPasswordSpecification(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.USER_LOGIN + " = ? AND " + SqlConstant.USER_PASSWORD + " = ?";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(login, password);
    }
}
