package com.training.rentapartment.service;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.entity.UserType;
import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.model.repository.user.UserRepository;
import com.training.rentapartment.model.specification.user.UserByLoginPasswordSpecification;
import com.training.rentapartment.service.validator.GuestValidator;
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

    public boolean logIn(String loginValue, String passwordValue) {
        boolean result = false;
        if (GuestValidator.validateLogin(loginValue, passwordValue)) {
            UserByLoginPasswordSpecification specification = new UserByLoginPasswordSpecification(loginValue, passwordValue);
            List<User> users = null;
            try {
                users = userRepository.query(specification);
            } catch (RepositoryException e) {
                logger.error(e.getMessage(), e);
            }
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
            user.setVerified(false);
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
                } catch (RepositoryException e) {
                    logger.error(e.getMessage(), e);
                }
                result = true;
            }
        }
        return result;
    }
}
