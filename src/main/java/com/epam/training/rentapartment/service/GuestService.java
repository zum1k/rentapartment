package com.epam.training.rentapartment.service;

import com.epam.training.rentapartment.entity.User;
import com.epam.training.rentapartment.repository.impl.user.UserRepository;
import com.epam.training.rentapartment.specification.impl.user.UserByLoginSpecification;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GuestService {
    static final String LOGIN_PARAMETER = "login";
    static final String PASSWORD_PARAMETER = "password";
    static final String EMAIL_PARAMETER = "email";

    public static final GuestService INSTANCE = new GuestService();
    private static final int USER_INDEX = 0;

    private UserRepository userRepository;

    private GuestService() {
    }

    public GuestService getINSTANCE() {
        return INSTANCE;
    }

    public boolean logIn(HttpServletRequest request) {
        String loginValue = request.getParameter(LOGIN_PARAMETER);
        String passwordValue = request.getParameter(PASSWORD_PARAMETER);

        if (Validator.logIndValidate(loginValue, passwordValue)) {
            List<User> users = userRepository.query(new UserByLoginSpecification());
            User currentUser = users.get(USER_INDEX);
            return currentUser.getLogin().equals(loginValue) && currentUser.getPassword().equals(passwordValue);
        } else {
            return false;
        }
    }

    public boolean register(HttpServletRequest request) {
        String loginValue = request.getParameter(LOGIN_PARAMETER);
        String passwordValue = request.getParameter(PASSWORD_PARAMETER);
        String emailValue = request.getParameter(EMAIL_PARAMETER);

        if (Validator.registerValidate(loginValue, passwordValue, emailValue)) {
            List<User> users = userRepository.query(new UserByLoginSpecification());
            User currentUser = users.get(USER_INDEX);
            return currentUser.getLogin().equals(loginValue) && currentUser.getPassword().equals(passwordValue);
        } else {
            return false;
        }
    }
}
