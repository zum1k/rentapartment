package com.training.rentapartment.entity;

import java.util.Objects;

public class Address {
    public static final String ADDRESS_TABLE_NAME = "address";

    private int addressId;
    private String city;
    private String street;
    private int houseNumber;
    private int houseIndex;

    public Address() {
    }

    public Address(int addressId, String city, String street, int houseNumber, int houseIndex) {
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.houseIndex = houseIndex;
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
        return addressId == address.addressId &&
                houseNumber == address.houseNumber &&
                houseIndex == address.houseIndex &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, city, street, houseNumber, houseIndex);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Address{" + ", addressId=")
                .append(addressId).append(", city='").append(city).append('\'')
                .append(", street='").append(street).append('\'')
                .append(", houseNumber=").append(houseNumber)
                .append(", houseIndex=").append(houseIndex)
                .append('}').toString();
    }
}
