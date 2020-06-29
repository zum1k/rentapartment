package com.epam.training.rentapartment.specification.impl.address;

import com.epam.training.rentapartment.entity.Address;
import com.epam.training.rentapartment.specification.Specification;

import java.util.List;

public class AddressByStreet implements Specification<Address> {
    @Override
    public String toSqlRequest() {
        return null;
    }

    @Override
    public List<Address> receiveParameters() {
        return null;
    }
}
