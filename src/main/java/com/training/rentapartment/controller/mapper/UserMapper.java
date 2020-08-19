package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.entity.UserType;
import com.training.rentapartment.model.repository.SqlConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserMapper implements EntityMapper<User> {
    @Override
    public User toEntity(HttpServletRequest request) throws IOException, ServletException {
        String login = request.getParameter(SqlConstant.USER_LOGIN);
        String password = request.getParameter(SqlConstant.USER_PASSWORD);
        UserType type = UserType.CLIENT;
        String email = request.getParameter(SqlConstant.USER_EMAIL);
        boolean verified = false;
        return new User(login, password, type, email, verified);
    }
}
