package com.training.rentapartment.model.repository.specification.adverstisement.rooms;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByRoomSpecification implements Specification {
    private final IntegerSqlQueryParameter roomNumber;

    public AdvertisementByRoomSpecification(int roomNumber) {
        this.roomNumber = new IntegerSqlQueryParameter(roomNumber);
    }

    @Override
    public String toSqlRequest() {
        return " AND " + SqlConstant.ADVERTISEMENT_ROOMS + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(roomNumber);
    }
}
