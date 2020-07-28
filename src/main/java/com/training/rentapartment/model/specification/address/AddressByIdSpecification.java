package com.training.rentapartment.model.specification.address;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class AddressByIdSpecification implements Specification {
    private final int addressId;

    public AddressByIdSpecification(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADDRESS_ID + " = ? ";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(addressId);
    }
}
