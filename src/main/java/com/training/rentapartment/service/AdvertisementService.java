package com.training.rentapartment.service;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.exception.ServiceException;

import java.util.List;

public interface AdvertisementService {
    void addAdvertisement(Advertisement advertisement, Address address, List<Image> images) throws ServiceException;
    List<AdvertisementDto> allAdvertisements(int pageOffset, int pageLimit) throws ServiceException;
}
