package com.epam.training.rentapartment.specification.impl.address;

import com.epam.training.rentapartment.entity.Address;
import com.epam.training.rentapartment.specification.Specification;

public class AddressByNumberLessThanSpecification implements Specification<Address> {
    @Override
    public boolean isSpecified(Address address) {
        return false;
    }
}
