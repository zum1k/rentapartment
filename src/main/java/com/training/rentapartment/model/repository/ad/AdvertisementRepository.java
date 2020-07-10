package com.training.rentapartment.model.repository.ad;

import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class AdvertisementRepository implements Repository<Advertisement>, AutoCloseable { //TODO
    private static final Logger LOGGER = LogManager.getLogger(AdvertisementRepository.class);

    @Override
    public void add(Advertisement ad) {
        //TODO
    }

    @Override
    public void remove(Advertisement ad) {
        //TODO
    }

    @Override
    public void update(Advertisement ad) {
        //TODO
    }


    @Override
    public List<Advertisement> query(Specification specification) {
        //TODO
        return null;
    }

    @Override
    public Optional<Advertisement> singleQuery(Specification specification) {
        return Optional.empty();
    }

    @Override
    public void close() throws Exception {
        //TODO
    }
}
