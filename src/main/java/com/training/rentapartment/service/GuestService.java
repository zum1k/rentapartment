package com.training.rentapartment.service;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.model.repository.user.UserRepository;
import com.training.rentapartment.model.specification.user.UserByLoginPasswordSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class GuestService {
    private static Logger logger = LogManager.getLogger(GuestService.class);
    private static GuestService INSTANCE = new GuestService();
    private static final int USER_INDEX = 0;

    private final UserRepository userRepository;

    private GuestService() {
        this.userRepository = new UserRepository();
    }

    public static GuestService getINSTANCE() {
        return INSTANCE;
    }

    public User logIn(String loginValue, String passwordValue) {
        boolean result = false;
        User currentUser = null;
        UserByLoginPasswordSpecification specification = new UserByLoginPasswordSpecification(loginValue, passwordValue);
        List<User> users = null;
        try {
            users = userRepository.query(specification);
        } catch (RepositoryException e) {
            logger.error(e.getMessage(), e);
        }
        if (users.size() > 0) {
            currentUser = users.get(USER_INDEX);
        }
        return currentUser;
    }

    public User register(User user) {
        User currentUser = null;
        String loginValue = user.getLogin();
        String passwordValue = user.getPassword();
        UserByLoginPasswordSpecification specification = new UserByLoginPasswordSpecification(loginValue, passwordValue);
        Optional<User> queriedUser = null;
        try {
            queriedUser = userRepository.singleQuery(specification);
        } catch (RepositoryException e) {
            logger.error(e.getMessage(), e);
        }
        if (queriedUser.isEmpty()) {
            try {
                userRepository.add(user);
                currentUser = user;
            } catch (RepositoryException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return currentUser;
    }
}

