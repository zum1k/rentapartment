package com.training.rentapartment.model.specification.address;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class AddressByHouseNumberOverThanSpecification implements Specification {
    private final Integer houseNumber;

    public AddressByHouseNumberOverThanSpecification(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADDRESS_HOUSE_NUMBER + " > ? ";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(houseNumber);
    }
}
