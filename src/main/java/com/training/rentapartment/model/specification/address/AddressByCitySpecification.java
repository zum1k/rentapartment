package com.training.rentapartment.model.specification.address;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class AddressByCitySpecification implements Specification {
    private final String city;

    public AddressByCitySpecification(String city) {
        this.city = city;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADDRESS_CITY + " = ? ";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(city);
    }
}
