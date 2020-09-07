package com.training.rentapartment.service.impl;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.model.repository.impl.user.UserRepository;
import com.training.rentapartment.model.repository.specification.user.AllUsersSpecification;
import com.training.rentapartment.model.repository.specification.user.UserByIdSpecification;
import com.training.rentapartment.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserRepository.class);
    private final static UserServiceImpl instance = new UserServiceImpl();
    private final UserRepository userRepository;

    private UserServiceImpl() {
        this.userRepository = new UserRepository();
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }


    public void deleteAccount(int userId) throws ServiceException {
        UserByIdSpecification userByIdSpecification = new UserByIdSpecification(userId);
        try {
            userRepository.remove(userByIdSpecification);
        } catch (RepositoryException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        AllUsersSpecification specification = new AllUsersSpecification();
        try {
            return userRepository.query(specification);
        } catch (RepositoryException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
