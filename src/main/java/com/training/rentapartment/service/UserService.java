package com.training.rentapartment.service;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.model.repository.address.AddressRepository;
import com.training.rentapartment.model.repository.advertisement.AdvertisementRepository;
import com.training.rentapartment.model.repository.image.ImageRepository;
import com.training.rentapartment.model.repository.user.UserRepository;

public class UserService { //TODO
    static final String LOGIN_PARAMETER = "login";
    static final String PASSWORD_PARAMETER = "password";
    static final String EMAIL_PARAMETER = "email";

    private static UserService INSTANCE = new UserService();
    private static final int USER_INDEX = 0;

    private final UserRepository userRepository;
    private final AdvertisementRepository advertisementRepository;
    private final AddressRepository addressRepository;
    private final ImageRepository imageRepository;

    private UserService() {
        this.userRepository = new UserRepository();
        this.advertisementRepository = new AdvertisementRepository();
        this.addressRepository = new AddressRepository();
        this.imageRepository = new ImageRepository();
    }

    public static UserService getINSTANCE() {
        return INSTANCE;
    }

    public boolean deleteAccount(int userId) {
        return false;
    }
}
