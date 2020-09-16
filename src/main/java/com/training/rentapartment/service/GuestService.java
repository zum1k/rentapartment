package com.training.rentapartment.service;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.ServiceException;

import java.util.Optional;

public interface GuestService {
    Optional<User> register(User user) throws ServiceException;

    Optional<User> logIn(String loginValue, String passwordValue) throws ServiceException;
}
