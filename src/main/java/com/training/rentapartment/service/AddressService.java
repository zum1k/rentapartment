package com.training.rentapartment.service;

import com.training.rentapartment.model.repository.address.AddressRepository;

public class AddressService {
    private static AddressService INSTANCE = new AddressService();
    private final AddressRepository addressRepository;

    private AddressService() {
        this.addressRepository = new AddressRepository();
    }

    public static AddressService getINSTANCE() {
        return INSTANCE;
    }
    public boolean addAdvertisement(){
        return false;
    }

    public boolean deleteAdvertisement(){
        return false;
    }

}
