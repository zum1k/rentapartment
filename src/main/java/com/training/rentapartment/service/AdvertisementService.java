package com.training.rentapartment.service;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.model.repository.address.AddressRepository;
import com.training.rentapartment.model.repository.advertisement.AdvertisementRepository;
import com.training.rentapartment.model.repository.image.ImageRepository;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementService { //TODO
    private static AdvertisementService INSTANCE = new AdvertisementService();
    private final AdvertisementRepository advertisementRepository;
    private final AddressRepository addressRepository;
    private final ImageRepository imageRepository;

    private AdvertisementService() {
        this.advertisementRepository = new AdvertisementRepository();
        this.addressRepository = new AddressRepository();
        this.imageRepository = new ImageRepository();
    }

    public static AdvertisementService getINSTANCE() {
        return INSTANCE;
    }

    public boolean deleteAdvertisement(int advertisementId){
        return false;
    }
    public boolean addAdvertisement(Advertisement advertisement, Address address, Image image){
        return false;
    }
    public AdvertisementDto findSingleAdvertisement(){
        Advertisement advertisement = new Advertisement();
        Address address = new Address();
        List<Image> imageList = new ArrayList<>();
        return new AdvertisementDto(advertisement, address, imageList);

    }
    public List<AdvertisementDto> findAdvertisements(){
        return new ArrayList<AdvertisementDto>();
    }

}
