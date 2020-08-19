package com.training.rentapartment.model.repository.specification.user;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.StringSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class UserByLoginEmailSpecification implements Specification {
    private final StringSqlQueryParameter login;
    private final StringSqlQueryParameter email;

    public UserByLoginEmailSpecification(String login, String email) {
        this.login = new StringSqlQueryParameter(login);
        this.email = new StringSqlQueryParameter(email);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.USER_LOGIN + " = ? AND " + SqlConstant.USER_PASSWORD + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(login, email);
    }
}
