package com.epam.training.rentapartment.specification.impl.user;

import com.epam.training.rentapartment.entity.User;
import com.epam.training.rentapartment.specification.Specification;

public class UserByLoginSpecification implements Specification<User> {
    private String requestLogin;

    public UserByLoginSpecification(String requestLogin){
        this.requestLogin = requestLogin;
    }
    @Override
    public boolean isSpecified(User user) {
        String currentLogin = user.getLogin();
        return currentLogin.equals(requestLogin);
    }
}
