package com.training.rentapartment.service.impl;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.model.repository.impl.user.UserRepository;
import com.training.rentapartment.model.repository.specification.user.UserByLoginEmailSpecification;
import com.training.rentapartment.model.repository.specification.user.UserByLoginPasswordSpecification;
import com.training.rentapartment.service.GuestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

import static java.util.List.of;

public class GuestServiceImpl implements GuestService {
    private static Logger logger = LogManager.getLogger(GuestServiceImpl.class);
    private static GuestServiceImpl instance = new GuestServiceImpl();
    private static final int USER_INDEX = 0;

    private final UserRepository userRepository;

    private GuestServiceImpl() {
        this.userRepository = new UserRepository();
    }

    public static GuestServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<User> logIn(String loginValue, String passwordValue) throws ServiceException {
        UserByLoginPasswordSpecification specification = new UserByLoginPasswordSpecification(loginValue, passwordValue);
        Optional<User> optionalUser;
        try {
           optionalUser = userRepository.singleQuery(specification);
           if(optionalUser.isPresent()){
              return optionalUser;
           }
        } catch (RepositoryException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(),e);
        }
        return optionalUser;
    }

    @Override
    public Optional<User> register(User user) throws ServiceException {
        String loginValue = user.getLogin();
        String emailValue = user.getEmail();
        UserByLoginEmailSpecification specification = new UserByLoginEmailSpecification(loginValue, emailValue);
        Optional<User> queriedUser;
        try {
            queriedUser = userRepository.singleQuery(specification);
            if(queriedUser.isEmpty()){
                userRepository.add(user);
                return Optional.of(user);
            }
        } catch (RepositoryException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
        return queriedUser;
    }
}

