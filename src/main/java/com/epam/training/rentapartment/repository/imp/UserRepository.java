package com.epam.training.rentapartment.repository.imp;

import com.epam.training.rentapartment.entity.User;
import com.epam.training.rentapartment.repository.Repository;
import com.epam.training.rentapartment.repository.Specification;

import java.util.Comparator;
import java.util.List;

public class UserRepository implements Repository<User>, AutoCloseable { //TODO
    @Override
    public void add(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> sort(Comparator<User> comparator) {
        return null;
    }

    @Override
    public List<User> query(Specification specification) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
