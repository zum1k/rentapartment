package com.training.rentapartment.entity.dto;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;

import java.util.List;
import java.util.Objects;

public class AdvertisementDto {
    private final Advertisement advertisement;
    private final Address address;
    private final List<Image> imageList;

    public AdvertisementDto(Advertisement advertisement, Address address, List<Image> imageList) {
        this.advertisement = advertisement;
        this.address = address;
        this.imageList = imageList;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public Address getAddress() {
        return address;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvertisementDto that = (AdvertisementDto) o;
        return Objects.equals(advertisement, that.advertisement) &&
                Objects.equals(address, that.address) &&
                Objects.equals(imageList, that.imageList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advertisement, address, imageList);
    }
}
