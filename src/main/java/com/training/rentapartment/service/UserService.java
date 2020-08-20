package com.training.rentapartment.service;

import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.ServiceException;

import java.util.List;

public interface UserService {
    void deleteAccount(int userId) throws ServiceException;
    List<User> findAllUsers() throws ServiceException;
}
