package com.epam.training.rentapartment.specification.impl.user;

import com.epam.training.rentapartment.entity.User;
import com.epam.training.rentapartment.specification.Specification;

import java.util.List;

public class UserByLoginPasswordSpecification implements Specification<User> {
    private String login;
    private String password;

    public UserByLoginPasswordSpecification(String login, String password){
        this.login = login;
        this.password = password;
    }
    @Override
    public String toSqlRequest() {
        return new StringBuilder().append("SELECT * FROM ")
                .append(User.USER_TABLE_NAME).append(" WHERE ").append(User.LOGIN)
                .append(" = ").append(this.login).toString();
    }
    @Override
    public List<User> receiveParameters() {
        return null;
    }
}
