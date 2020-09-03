package com.training.rentapartment.service;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface AdvertisementService {
    int addAdvertisement(Advertisement advertisement, Address address) throws ServiceException;
    List<AdvertisementDto> findAllAdvertisements(int pageOffset, int pageLimit) throws ServiceException;
    void addImages(List<Image> images) throws ServiceException;
    boolean deleteAdvertisement(int advertisementId) throws ServiceException;
    Optional<AdvertisementDto> findSingleAdvertisement(int advertisementId) throws ServiceException;
}
