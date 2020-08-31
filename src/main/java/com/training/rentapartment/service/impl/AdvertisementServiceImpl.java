package com.training.rentapartment.service.impl;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.model.repository.impl.address.AddressRepository;
import com.training.rentapartment.model.repository.impl.advertisement.AdvertisementRepository;
import com.training.rentapartment.model.repository.impl.image.ImageRepository;
import com.training.rentapartment.model.repository.specification.address.AddressByAllParametersSpecification;
import com.training.rentapartment.model.repository.specification.address.AddressByIdSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.AdvertisementByLimitAndOffsetSpecification;
import com.training.rentapartment.model.repository.specification.image.ImageByAdvertisementIdSpecification;
import com.training.rentapartment.service.AdvertisementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdvertisementServiceImpl implements AdvertisementService { //TODO
    private static final Logger LOGGER = LogManager.getLogger(AdvertisementServiceImpl.class);
    private final int DEFAULT_ID_VALUE = 0;
    private static AdvertisementServiceImpl instance = new AdvertisementServiceImpl();
    private final AdvertisementRepository advertisementRepository;
    private final AddressRepository addressRepository;
    private final ImageRepository imageRepository;

    private AdvertisementServiceImpl() {
        this.advertisementRepository = new AdvertisementRepository();
        this.addressRepository = new AddressRepository();
        this.imageRepository = new ImageRepository();
    }

    public static AdvertisementServiceImpl getInstance() {
        return instance;
    }

    public boolean deleteAdvertisement(int advertisementId) {

        return false;
    }

    @Override
    public int addAdvertisement(Advertisement advertisement, Address address) throws ServiceException {
        int advertisementId = DEFAULT_ID_VALUE;
        try {
            int addressId;
            Optional<Address> optionalAddress = addressRepository.singleQuery(new AddressByAllParametersSpecification(address));
            if (optionalAddress.isPresent()) {
                addressId = optionalAddress.get().getAddressId();
            } else {
                addressId = addressRepository.add(address);
            }
            advertisementId = addAdvertisementWithAddress(addressId, advertisement);
        } catch (RepositoryException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
        return advertisementId;
    }

    public AdvertisementDto findSingleAdvertisement() { //todo
        Advertisement advertisement = new Advertisement();
        Address address = new Address();
        List<Image> imageList = new ArrayList<>();
        return new AdvertisementDto(advertisement, address, imageList);
    }

    private int addAdvertisementWithAddress(int addressId, Advertisement advertisement) throws RepositoryException {
        advertisement.setAddressId(addressId);
        return advertisementRepository.add(advertisement);
    }

    public List<AdvertisementDto> findAllAdvertisements(int pageOffset, int pageLimit) throws ServiceException {
        List<AdvertisementDto> dtos = new ArrayList<>();
        AdvertisementByLimitAndOffsetSpecification specification =
                new AdvertisementByLimitAndOffsetSpecification(pageOffset, pageLimit);
        try {
            List<Advertisement> queriedAdvertisements = advertisementRepository.query(specification);
            for (Advertisement advertisement : queriedAdvertisements) {
                Address address = findAddressByAdId(advertisement);
                List<Image> imageList = findImagesByAdId(advertisement);
                AdvertisementDto advertisementDto = new AdvertisementDto(advertisement, address, imageList);
                dtos.add(advertisementDto);
            }
        } catch (RepositoryException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e);
        }
        return dtos;
    }

    @Override
    public void addImages(List<Image> images) throws ServiceException {
        try {
            for (Image image : images) {
                imageRepository.add(image);
            }
        } catch (RepositoryException e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
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
        Optional<Address> addressOptional = addressRepository.singleQuery(specification);
        return addressOptional.orElseGet(Address::new);
    }
}
