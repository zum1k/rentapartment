package com.training.rentapartment.service;

import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.model.repository.user.UserRepository;
import com.training.rentapartment.model.specification.user.UserByIdSpecification;

public class UserService {
    private static UserService INSTANCE = new UserService();
    private final UserRepository userRepository;

    private UserService() {
        this.userRepository = new UserRepository();
    }

    public static UserService getINSTANCE() {
        return INSTANCE;
    }

    public boolean deleteAccount(int userId) {
        boolean result = false;
        UserByIdSpecification userByIdSpecification = new UserByIdSpecification(userId);
        try {
            userRepository.remove(userByIdSpecification);
            result = true;
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
