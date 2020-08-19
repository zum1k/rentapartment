package com.training.rentapartment.service;

import com.training.rentapartment.exception.ServiceException;

public interface UserService {
    void deleteAccount(int userId) throws ServiceException;
}
