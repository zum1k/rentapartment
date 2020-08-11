package com.training.rentapartment.service;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.model.repository.address.AddressRepository;
import com.training.rentapartment.model.repository.advertisement.AdvertisementRepository;
import com.training.rentapartment.model.repository.image.ImageRepository;
import com.training.rentapartment.model.specification.address.AddressByAllParametersSpecification;
import com.training.rentapartment.model.specification.address.AddressByIdSpecification;
import com.training.rentapartment.model.specification.adverstisement.AdvertisementByLimitAndOffsetSpecification;
import com.training.rentapartment.model.specification.image.ImageByAdvertisementIdSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementService { //TODO
    private static final Logger LOGGER = LogManager.getLogger(AdvertisementService.class);
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

    public boolean deleteAdvertisement(int advertisementId) {
        return false;
    }

    public void addAdvertisement(Advertisement advertisement, Address address, List<Image> image) {
        try {
            addressRepository.singleQuery(new AddressByAllParametersSpecification(address));
            addressRepository.add(address);

            advertisementRepository.add(advertisement);
            int advertisementId = advertisementRepository.singleQuery(); //TODO
            address.se
        } catch (RepositoryException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public AdvertisementDto findSingleAdvertisement() {
        Advertisement advertisement = new Advertisement();
        Address address = new Address();
        List<Image> imageList = new ArrayList<>();
        return new AdvertisementDto(advertisement, address, imageList);

    }

    public List<AdvertisementDto> allAdvertisements(int pageOffset, int pageLimit) {
        List<AdvertisementDto> dtoList = null;
        Address address = null;
        List<Image> imageList = null;
        AdvertisementByLimitAndOffsetSpecification specification =
                new AdvertisementByLimitAndOffsetSpecification(pageOffset, pageLimit);
        try {
            List<Advertisement> queriedAdvertisements = advertisementRepository.query(specification);
            for (Advertisement advertisement : queriedAdvertisements) {
                address = findAddressByAdId(advertisement);
                imageList = findImagesByAdId(advertisement);
                AdvertisementDto advertisementDto = new AdvertisementDto(advertisement, address, imageList);
                dtoList.add(advertisementDto);
            }
        } catch (RepositoryException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return dtoList;
    }

    private List<Image> findImagesByAdId(Advertisement advertisement) throws RepositoryException {
        int advertisementId = advertisement.getAdId();
        ImageByAdvertisementIdSpecification imageByIdSpecification =
                new ImageByAdvertisementIdSpecification(advertisementId);
        return imageRepository.query(imageByIdSpecification);
    }
    private Address findAddressByAdId(Advertisement advertisement) throws RepositoryException {
        int addressId = advertisement.getAddressId();
        AddressByIdSpecification specification = new AddressByIdSpecification(addressId);
       return addressRepository.singleQuery(specification).get();
    }
}
