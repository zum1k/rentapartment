package com.training.rentapartment.model.repository.specification.adverstisement.rooms;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByRoomLessThanSpecification implements Specification {
    private final IntegerSqlQueryParameter roomNumber;

    public AdvertisementByRoomLessThanSpecification(int roomNumber) {
        this.roomNumber = new IntegerSqlQueryParameter(roomNumber);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_ROOMS + " < ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(roomNumber);
    }
}
