package com.training.rentapartment.model.repository.address;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.Specification;

import java.util.List;
import java.util.Optional;

public class AddressRepository implements Repository<Address>, AutoCloseable {
    @Override
    public void add(Address address) {
    }

    @Override
    public void remove(Specification specification) {
    }

    @Override
    public List<Address> query(Specification specification) {
        return null;
    }

    @Override
    public Optional<Address> singleQuery(Specification specification) {
        return Optional.empty();
    }

    @Override
    public void close() throws Exception {
    }
}
