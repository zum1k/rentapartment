package com.epam.training.rentapartment.repository.imp;

import com.epam.training.rentapartment.entity.Ad;
import com.epam.training.rentapartment.repository.Repository;
import com.epam.training.rentapartment.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class RepositoryImpl implements Repository<Ad>, AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(RepositoryImpl.class);

    @Override
    public void add(Ad ad) {
        //TODO
    }

    @Override
    public void remove(Ad ad) {
        //TODO
    }

    @Override
    public void update(Ad ad) {
        //TODO
    }

    @Override
    public List<Ad> findAll() {
        return null;
    }

    @Override
    public List<Ad> sort(Comparator<Ad> comparator) {
        return null;
    }

    @Override
    public List<Ad> query(Specification specification) {
        return null;
    }

    @Override
    public void close() throws Exception {
        //TODO
    }
}
