package com.training.rentapartment.entity;

import java.util.Objects;

public class Advertisement {
    public static final String AD_TABLE_NAME = "ad";

    private int adId;
    private int cost;
    private int rooms;
    private int floor;
    private double square;
    private double livingSquare;
    private double kitchenSquare;
    private OwnerType owner;
    private String phoneNumber;
    private String adDate;
    private int addressId;
    private int userId;
    private String description;

    public Advertisement() {
    }

    public Advertisement(int cost, int rooms, int floor, double square, double livingSquare,
                         double kitchenSquare, OwnerType owner, String phoneNumber, String description) {
        this.cost = cost;
        this.rooms = rooms;
        this.floor = floor;
        this.square = square;
        this.livingSquare = livingSquare;
        this.kitchenSquare = kitchenSquare;
        this.owner = owner;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getLivingSquare() {
        return livingSquare;
    }

    public void setLivingSquare(double livingSquare) {
        this.livingSquare = livingSquare;
    }

    public double getKitchenSquare() {
        return kitchenSquare;
    }

    public void setKitchenSquare(double kitchenSquare) {
        this.kitchenSquare = kitchenSquare;
    }

    public OwnerType getOwner() {
        return owner;
    }

    public void setOwner(OwnerType owner) {
        this.owner = owner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return adId == that.adId &&
                cost == that.cost &&
                rooms == that.rooms &&
                floor == that.floor &&
                Double.compare(that.square, square) == 0 &&
                Double.compare(that.livingSquare, livingSquare) == 0 &&
                Double.compare(that.kitchenSquare, kitchenSquare) == 0 &&
                addressId == that.addressId &&
                userId == that.userId &&
                owner == that.owner &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, cost, rooms, floor, square, livingSquare,
                kitchenSquare, owner, phoneNumber, addressId, userId, description);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Ad{" + "adId=").append(adId).append(", cost=")
                .append(cost).append(", rooms=").append(rooms).append(", floor=")
                .append(floor).append(", square=").append(square).append(", livingSquare=")
                .append(livingSquare).append(", kitchenSquare=").append(kitchenSquare)
                .append(", owner=").append(owner).append(", phoneNumber='").append(phoneNumber)
                .append('\'').append(", addressId=")
                .append(addressId).append(", userId=")
                .append(userId).append(", description='").append(description).append('\'')
                .append('}').toString();
    }
}
