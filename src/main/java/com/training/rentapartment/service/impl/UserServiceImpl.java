package com.training.rentapartment.service.impl;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.model.repository.Repository;
import com.training.rentapartment.model.repository.impl.user.UserRepository;
import com.training.rentapartment.model.repository.specification.user.AllUsersByUserTypeSpecification;
import com.training.rentapartment.model.repository.specification.user.UserByIdSpecification;
import com.training.rentapartment.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final String CLIENT_TYPE = "client";
    private final String ADMIN_TYPE = "admin";
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {
    }

    public void deleteAccount(int userId) throws ServiceException {
        UserByIdSpecification userByIdSpecification = new UserByIdSpecification(userId);
        try (Repository<User> userRepository = new UserRepository()) {
            userRepository.remove(userByIdSpecification);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<User> findAllClientUsers() throws ServiceException {
        AllUsersByUserTypeSpecification specification = new AllUsersByUserTypeSpecification(CLIENT_TYPE);
        try (Repository<User> userRepository = new UserRepository()) {
            return userRepository.query(specification);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<User> findAllAdminUsers() throws ServiceException {
        AllUsersByUserTypeSpecification specification = new AllUsersByUserTypeSpecification(ADMIN_TYPE);
        try (Repository<User> userRepository = new UserRepository()) {
            return userRepository.query(specification);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
