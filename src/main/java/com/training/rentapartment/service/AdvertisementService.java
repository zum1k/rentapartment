package com.training.rentapartment.service;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.exception.ServiceException;

import java.util.List;

public interface AdvertisementService {
    int addAdvertisement(Advertisement advertisement, Address address) throws ServiceException;
    List<AdvertisementDto> findAllAdvertisements(int pageOffset, int pageLimit) throws ServiceException;
    void addImages(List<Image> images) throws ServiceException;
}
