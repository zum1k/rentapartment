package com.training.rentapartment.service.impl;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.model.repository.Repository;
import com.training.rentapartment.model.repository.impl.user.UserRepository;
import com.training.rentapartment.model.repository.specification.user.UserByLoginEmailSpecification;
import com.training.rentapartment.model.repository.specification.user.UserByLoginPasswordSpecification;
import com.training.rentapartment.service.GuestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;


public class GuestServiceImpl implements GuestService {
    private static Logger logger = LogManager.getLogger(GuestServiceImpl.class);

    public GuestServiceImpl() {
    }

    @Override
    public Optional<User> logIn(String loginValue, String passwordValue) throws ServiceException {
        UserByLoginPasswordSpecification specification = new UserByLoginPasswordSpecification(loginValue, passwordValue);
        try (Repository<User> userRepository = new UserRepository()) {
            return userRepository.singleQuery(specification);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<User> register(User user) throws ServiceException {
        String loginValue = user.getLogin();
        String emailValue = user.getEmail();
        UserByLoginEmailSpecification specification = new UserByLoginEmailSpecification(loginValue, emailValue);
        Optional<User> queriedUser;
        try (Repository<User> userRepository = new UserRepository()) {
            queriedUser = userRepository.singleQuery(specification);
            if (queriedUser.isEmpty()) {
                userRepository.add(user);
                return Optional.of(user);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
        return queriedUser;
    }
}

