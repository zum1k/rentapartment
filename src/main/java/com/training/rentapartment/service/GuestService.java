package com.training.rentapartment.service;

import com.training.rentapartment.model.pool.ConnectionPool;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.model.repository.user.UserRepository;
import com.training.rentapartment.model.specification.user.UserByLoginPasswordSpecification;
import com.training.rentapartment.service.validator.GuestValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GuestService {
    static final String LOGIN_PARAMETER = "login";
    static final String PASSWORD_PARAMETER = "password";
    static final String EMAIL_PARAMETER = "email";

    private static GuestService INSTANCE = new GuestService();
    private static final int USER_INDEX = 0;

    private UserRepository userRepository;

    private GuestService() {
        this.userRepository = new UserRepository();
    }

    public static GuestService getINSTANCE() {
        return INSTANCE;
    }

    public boolean logIn(HttpServletRequest request) {
        String loginValue = request.getParameter(LOGIN_PARAMETER);
        String passwordValue = request.getParameter(PASSWORD_PARAMETER);
        boolean result = false;

        if (GuestValidator.validateLogin(loginValue, passwordValue)) {
            List<User> users = userRepository.query(new UserByLoginPasswordSpecification(loginValue, passwordValue));
            if (users.size() > 0) {            //TODO
                User currentUser = users.get(USER_INDEX);
                result = currentUser.getLogin().equals(loginValue) && currentUser.getPassword().equals(passwordValue);
            }
        }
        return result;
    }

    public boolean register(HttpServletRequest request) { //TODO
//        String loginValue = request.getParameter(LOGIN_PARAMETER);
//        String passwordValue = request.getParameter(PASSWORD_PARAMETER);
//        String emailValue = request.getParameter(EMAIL_PARAMETER);
//
//        if (Validator.registerValidate(loginValue, passwordValue, emailValue)) {
//            List<User> users = userRepository.add(new User(loginValue, passwordValue, emailValue));
//            User currentUser = users.get(USER_INDEX);
//            return currentUser.getLogin().equals(loginValue) && currentUser.getPassword().equals(passwordValue);
//        } else {
//            return false;
//        }
        return false;
    }
}