package com.training.rentapartment.service;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.entity.UserType;
import com.training.rentapartment.model.repository.user.UserRepository;
import com.training.rentapartment.model.specification.user.UserByLoginPasswordSpecification;
import com.training.rentapartment.service.validator.GuestValidator;

import java.util.List;
import java.util.Optional;

public class GuestService {
    static final String LOGIN_PARAMETER = "login";
    static final String PASSWORD_PARAMETER = "password";
    static final String EMAIL_PARAMETER = "email";

    private static GuestService INSTANCE = new GuestService();
    private static final int USER_INDEX = 0;

    private final UserRepository userRepository;

    private GuestService() {
        this.userRepository = new UserRepository();
    }

    public static GuestService getINSTANCE() {
        return INSTANCE;
    }

    public boolean logIn(String loginValue, String passwordValue) {
        boolean result = false;
        if (GuestValidator.validateLogin(loginValue, passwordValue)) {
            UserByLoginPasswordSpecification specification = new UserByLoginPasswordSpecification(loginValue, passwordValue);
            List<User> users = userRepository.query(specification);
            if (users.size() > 0) {            //TODO
                User currentUser = users.get(USER_INDEX);
                result = currentUser.getLogin().equals(loginValue) && currentUser.getPassword().equals(passwordValue);
            }
        }
        return result;
    }

    public boolean register(String loginValue, String passwordValue, String emailValue) {
        boolean result = false;
        if (GuestValidator.validateRegistration(loginValue, passwordValue, emailValue)) {
            User user = new User();
            user.setLogin(loginValue);
            user.setPassword(passwordValue);
            user.setEmail(emailValue);
            user.setType(UserType.CLIENT);
            UserByLoginPasswordSpecification specification = new UserByLoginPasswordSpecification(loginValue, passwordValue);
            Optional<User> queriedUser = userRepository.singleQuery(specification);
            if (queriedUser.isEmpty()) {
                userRepository.add(user);
                result = true;
            }
        }
        return result;
    }
}
