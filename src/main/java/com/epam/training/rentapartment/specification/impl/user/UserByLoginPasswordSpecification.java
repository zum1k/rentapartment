package com.epam.training.rentapartment.specification.impl.user;

import com.epam.training.rentapartment.entity.User;
import com.epam.training.rentapartment.specification.Specification;

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
        return " WHERE " + User.LOGIN + " = ? AND " + User.PASSWORD + " = ?";
    }

    @Override
    public List<String> receiveParameters() {
        return Arrays.asList(login, password);
    }
}
