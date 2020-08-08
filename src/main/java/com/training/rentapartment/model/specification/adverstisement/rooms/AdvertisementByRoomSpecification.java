package com.training.rentapartment.model.specification.adverstisement.rooms;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByRoomSpecification implements Specification {
    private final IntegerSqlQueryParameter roomNumber;

    public AdvertisementByRoomSpecification(int roomNumber) {
        this.roomNumber = new IntegerSqlQueryParameter(roomNumber);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_ROOMS + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(roomNumber);
    }
}
