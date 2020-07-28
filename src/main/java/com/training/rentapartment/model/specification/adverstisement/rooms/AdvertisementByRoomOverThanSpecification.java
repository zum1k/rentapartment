package com.training.rentapartment.model.specification.adverstisement.rooms;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByRoomOverThanSpecification implements Specification {
    private final int roomNumber;

    public AdvertisementByRoomOverThanSpecification(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_ROOMS + " > ?";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(roomNumber);
    }
}
