package com.epam.training.rentapartment.repository.imp;

import com.epam.training.rentapartment.entity.Address;
import com.epam.training.rentapartment.repository.Repository;
import com.epam.training.rentapartment.repository.Specification;

import java.util.Comparator;
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
    public List<Address> sort(Comparator<Address> comparator) {
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
