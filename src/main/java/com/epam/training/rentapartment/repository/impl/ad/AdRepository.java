package com.epam.training.rentapartment.repository.impl.ad;

import com.epam.training.rentapartment.entity.Ad;
import com.epam.training.rentapartment.repository.Repository;
import com.epam.training.rentapartment.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class AdRepository implements Repository<Ad>, AutoCloseable { //TODO
    private static final Logger LOGGER = LogManager.getLogger(AdRepository.class);

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
        //TODO
        return null;
    }

    @Override
    public List<Ad> sort(Comparator<Ad> comparator) {
        //TODO
        return null;
    }

    @Override
    public List<Ad> query(Specification specification) {
        //TODO
        return null;
    }

    @Override
    public void close() throws Exception {
        //TODO
    }
}
