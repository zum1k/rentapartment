package com.training.rentapartment.model.specification.address;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class AddressByStreetSpecification implements Specification {
    private final String street;

    public AddressByStreetSpecification(String street) {
        this.street = street;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADDRESS_STREET + " = ? ";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(street);
    }
}
