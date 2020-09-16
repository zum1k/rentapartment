package com.training.rentapartment.controller.mapper;

import com.training.rentapartment.controller.EntityMapper;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.entity.UserType;
import com.training.rentapartment.model.repository.SqlConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserMapper implements EntityMapper<User> {
    @Override
    public User toEntity(HttpServletRequest request) throws IOException, ServletException {
        String login = request.getParameter(HttpRequestParameters.LOGIN);
        String password = request.getParameter(HttpRequestParameters.PASSWORD);
        String email = request.getParameter(HttpRequestParameters.EMAIL);
        int verified = 0;
        return new User(login, password, email, verified);
    }

    @Override
    public List<User> toEntityList(HttpServletRequest request) throws IOException, ServletException {
        return null;
    }

    public User parseSession(HttpServletRequest request){
        return (User)request.getSession().getAttribute(SessionAttribute.USER);
    }
}
