package com.epam.training.rentapartment.service;

import com.epam.training.rentapartment.entity.User;
import com.epam.training.rentapartment.repository.impl.user.UserRepository;
import com.epam.training.rentapartment.specification.impl.user.UserByLoginSpecification;

import java.util.List;

public class GuestService {
    private static final int USER_INDEX = 0;
    private static final String LOGIN_PATTERN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{7,14}$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]{9,14}$ ";
    private static final String EMAIL_PATTERN = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

    private UserRepository userRepository;

    public void logIn() {
    }

    public void register() {
    }

    public boolean checkUser(String login, String password) {
        if (login == null && password == null) {
            return false;
        } else {
            List<User> users = userRepository.query(new UserByLoginSpecification(login));
            User currentUser = users.get(USER_INDEX);
            return currentUser.getLogin().equals(login) && currentUser.getPassword().equals(password);
        }
    }

    public boolean checkUser(String login, String password, String email) {
        if (login == null && password == null && email==null) {
            return false;
        } else {
            List<User> users = userRepository.query(new UserByLoginSpecification(login));
            User currentUser = users.get(USER_INDEX);
            return currentUser.getLogin().equals(login) && currentUser.getPassword().equals(password);
        }
    }
}
