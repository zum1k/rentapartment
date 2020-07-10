package com.training.rentapartment.model.repository.address;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.Specification;

import java.util.List;

public class AddressRepository implements Repository<Address>, AutoCloseable { //TODO
    @Override
    public void add(Address address) {
    }

    @Override
    public void remove(Address address) {
    }

    @Override
    public void update(Address address) {
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public List<Address> query(Specification specification) {
        return null;
    }

    @Override
    public void close() throws Exception {
    }
}
