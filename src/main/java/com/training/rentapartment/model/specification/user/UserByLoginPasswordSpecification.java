package com.training.rentapartment.model.specification.user;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.StringSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class UserByLoginPasswordSpecification implements Specification {
    private final StringSqlQueryParameter login;
    private final StringSqlQueryParameter password;

    public UserByLoginPasswordSpecification(String login, String password) {
        this.login = new StringSqlQueryParameter(login);
        this.password = new StringSqlQueryParameter(password);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.USER_LOGIN + " = ? AND " + SqlConstant.USER_PASSWORD + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(login, password);
    }
}
