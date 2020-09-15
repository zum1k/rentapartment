package com.training.rentapartment.service.impl;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.entity.dto.AdvertisementQueryDto;
import com.training.rentapartment.entity.dto.ImageDto;
import com.training.rentapartment.exception.RepositoryException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.model.repository.Repository;
import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.impl.address.AddressRepository;
import com.training.rentapartment.model.repository.impl.advertisement.AdvertisementRepository;
import com.training.rentapartment.model.repository.impl.image.ImageRepository;
import com.training.rentapartment.model.repository.specification.address.AddressByAllParametersSpecification;
import com.training.rentapartment.model.repository.specification.address.AddressByIdSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.AdvertisementByFiltersSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.AdvertisementByIdSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.AdvertisementByLimitAndOffsetSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.cost.AdvertisementByCostLessThanSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.cost.AdvertisementByCostOverThanSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.floor.AdvertisementByFloorLessThanSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.floor.AdvertisementByFloorOverThanSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.floor.AdvertisementByFloorSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.rooms.AdvertisementByRoomLessThanSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.rooms.AdvertisementByRoomOverThanSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.rooms.AdvertisementByRoomSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.square.AdvertisementBySquareLessThanSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.square.AdvertisementBySquareOverThanSpecification;
import com.training.rentapartment.model.repository.specification.adverstisement.user.AdvertisementByUserIdSpecification;
import com.training.rentapartment.model.repository.specification.image.ImageByAdvertisementIdSpecification;
import com.training.rentapartment.service.AdvertisementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

public class AdvertisementServiceImpl implements AdvertisementService {
    private static final Logger LOGGER = LogManager.getLogger(AdvertisementServiceImpl.class);

    public AdvertisementServiceImpl() {
    }

    @Override
    public boolean deleteAdvertisement(int advertisementId) throws ServiceException {
        AdvertisementByIdSpecification idSpecification = new AdvertisementByIdSpecification(advertisementId);
        ImageByAdvertisementIdSpecification imageSpecification = new ImageByAdvertisementIdSpecification(advertisementId);
        try (Repository<Advertisement> advertisementRepository = new AdvertisementRepository(); Repository<Image> imageRepository = new ImageRepository()) {
            advertisementRepository.remove(idSpecification);
            imageRepository.remove(imageSpecification);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int addAdvertisement(Advertisement advertisement, Address address) throws ServiceException {
        try (Repository<Address> addressRepository = new AddressRepository(); Repository<Advertisement> advertisementRepository = new AdvertisementRepository()) {
            int addressId;
            Optional<Address> optionalAddress = addressRepository.singleQuery(createAddressSpecification(address));
            if (optionalAddress.isPresent()) {
                addressId = optionalAddress.get().getAddressId();
            } else {
                addressId = addressRepository.add(address);
            }
            return addAdvertisementWithAddress(addressId, advertisement, advertisementRepository);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<AdvertisementDto> findSingleAdvertisement(int advertisementId) throws ServiceException {
        try (Repository<Advertisement> advertisementRepository = new AdvertisementRepository()) {
            AdvertisementByIdSpecification idSpecification = new AdvertisementByIdSpecification(advertisementId);
            Optional<Advertisement> optionalAdvertisement = advertisementRepository.singleQuery(idSpecification);
            if (optionalAdvertisement.isPresent()) {
                Advertisement advertisement = optionalAdvertisement.get();
                return Optional.ofNullable(createAdvertisementDto(advertisement));
            }
            return Optional.empty();

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<AdvertisementDto> findAllAdvertisements(int pageOffset, int pageLimit) throws ServiceException {
        AdvertisementByLimitAndOffsetSpecification specification =
                new AdvertisementByLimitAndOffsetSpecification(pageOffset, pageLimit);
        return findAdvertisements(specification);
    }

    @Override
    public List<AdvertisementDto> findUserAdvertisements(int userId) throws ServiceException {
        AdvertisementByUserIdSpecification specification = new AdvertisementByUserIdSpecification(userId);
        return findAdvertisements(specification);
    }

    @Override
    public List<AdvertisementDto> findAdvertisementsByFilters(AdvertisementQueryDto queryDto) throws ServiceException {
        AdvertisementByFiltersSpecification specification = new AdvertisementByFiltersSpecification(createSpecifications(queryDto));
        return findAdvertisements(specification);
    }

    private List<Specification> createSpecifications(AdvertisementQueryDto queryDto) {
        List<Specification> specifications = new ArrayList<>();
        Map<String, Number> parameters = queryDto.getQueryParams();
        for (String key : parameters.keySet()) {
            Specification specification;
            Number value = parameters.get(key);
            switch (key) {
                case "min_square":
                    specification = new AdvertisementBySquareOverThanSpecification(value.doubleValue());
                    specifications.add(specification);
                    break;
                case "max_square":
                    specification = new AdvertisementBySquareLessThanSpecification(value.doubleValue());
                    specifications.add(specification);
                    break;
                case "min_cost":
                    specification = new AdvertisementByCostOverThanSpecification(value.intValue());
                    specifications.add(specification);
                    break;
                case "max_cost":
                    specification = new AdvertisementByCostLessThanSpecification(value.intValue());
                    specifications.add(specification);
                    break;
                case "room":
                    specification = new AdvertisementByRoomSpecification(value.intValue());
                    specifications.add(specification);
                    break;
                case "min_room":
                    specification = new AdvertisementByRoomOverThanSpecification(value.intValue());
                    specifications.add(specification);
                    break;
                case "max_room":
                    specification = new AdvertisementByRoomLessThanSpecification(value.intValue());
                    specifications.add(specification);
                    break;
                case "floor":
                    specification = new AdvertisementByFloorSpecification(value.intValue());
                    specifications.add(specification);
                    break;
                case "min_floor":
                    specification = new AdvertisementByFloorOverThanSpecification(value.intValue());
                    specifications.add(specification);
                    break;
                case "max_floor":
                    specification = new AdvertisementByFloorLessThanSpecification(value.intValue());
                    specifications.add(specification);
                    break;
            }
        }
        return specifications;
    }

    private List<AdvertisementDto> findAdvertisements(Specification specification) throws ServiceException {
        List<AdvertisementDto> dtos = new ArrayList<>();
        try (Repository<Advertisement> advertisementRepository = new AdvertisementRepository()) {
            List<Advertisement> queriedAdvertisements = advertisementRepository.query(specification);
            for (Advertisement advertisement : queriedAdvertisements) {
                AdvertisementDto advertisementDto = createAdvertisementDto(advertisement);
                dtos.add(advertisementDto);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e);
        }
        return dtos;
    }

    private int addAdvertisementWithAddress(int addressId, Advertisement advertisement, Repository<Advertisement> advertisementRepository) throws RepositoryException {
        advertisement.setAddressId(addressId);
        return advertisementRepository.add(advertisement);
    }

    private AdvertisementDto createAdvertisementDto(Advertisement advertisement) throws RepositoryException {
        try (Repository<Image> imageRepository = new ImageRepository(); Repository<Address> addressRepository = new AddressRepository()) {
            int advertisementId = advertisement.getAdId();
            int addressId = advertisement.getAddressId();
            List<ImageDto> imageList = convertToDtoImage(findImagesByAdId(advertisementId, imageRepository));
            Address address = findAddressByAdId(addressId, addressRepository);
            return new AdvertisementDto(advertisement, address, imageList);
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void addImages(List<Image> images) throws ServiceException {
        try (Repository<Image> imageRepository = new ImageRepository()) {
            for (Image image : images) {
                imageRepository.add(image);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private List<ImageDto> convertToDtoImage(List<Image> images) throws IOException {
        List<ImageDto> imageDtos = new ArrayList<>();
        for (Image image : images) {
            ImageDto imageDto = convertFromBytesToImageDto(image.getImageData());
            imageDtos.add(imageDto);
        }
        return imageDtos;
    }

    private ImageDto convertFromBytesToImageDto(byte[] bytes) throws IOException {
        String base64Image = Base64.getEncoder().encodeToString(bytes);
        return new ImageDto(base64Image);
    }

    private List<Image> findImagesByAdId(int advertisementId, Repository<Image> imageRepository) throws RepositoryException {
        ImageByAdvertisementIdSpecification imageByIdSpecification =
                new ImageByAdvertisementIdSpecification(advertisementId);
        return imageRepository.query(imageByIdSpecification);
    }

    private Address findAddressByAdId(int addressId, Repository<Address> addressRepository) throws RepositoryException {
        AddressByIdSpecification specification = new AddressByIdSpecification(addressId);
        Optional<Address> addressOptional = addressRepository.singleQuery(specification);
        return addressOptional.orElseGet(Address::new);
    }

    private AddressByAllParametersSpecification createAddressSpecification(Address address) {
        String city = address.getCity();
        String street = address.getStreet();
        int houseNumber = address.getHouseNumber();
        int houseIndex = address.getHouseIndex();
        return new AddressByAllParametersSpecification(city, street, houseNumber, houseIndex);
    }
}
