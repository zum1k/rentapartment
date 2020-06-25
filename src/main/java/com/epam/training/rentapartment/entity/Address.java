package com.epam.training.rentapartment.entity;

import java.util.Objects;

public class Address {
    private int addressId;
    private int adId;
    private String city;
    private String street;
    private int houseNumber;
    private int houseIndex;

    public Address() {
    }

    public Address(int addressId, int adId, String city, String street, int houseNumber, int houseIndex) {
        this.addressId = addressId;
        this.adId = adId;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.houseIndex = houseIndex;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getHouseIndex() {
        return houseIndex;
    }

    public void setHouseIndex(int houseIndex) {
        this.houseIndex = houseIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return adId == address.adId &&
                addressId == address.addressId &&
                houseNumber == address.houseNumber &&
                houseIndex == address.houseIndex &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, addressId, city, street, houseNumber, houseIndex);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Address{" + "adId=")
                .append(adId).append(", addressId=").append(addressId)
                .append(", city='").append(city).append('\'')
                .append(", street='").append(street).append('\'')
                .append(", houseNumber=").append(houseNumber)
                .append(", houseIndex=").append(houseIndex)
                .append('}').toString();
    }
}
