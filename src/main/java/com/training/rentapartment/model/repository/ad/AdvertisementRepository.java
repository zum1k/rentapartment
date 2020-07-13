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
    public void add(Advertisement advertisement) {

    }

    @Override
    public void remove(Specification specification) {

    }

    @Override
    public List<Advertisement> query(Specification specification) {
        return null;
    }

    @Override
    public Optional<Advertisement> singleQuery(Specification specification) {
        return Optional.empty();
    }

    @Override
    public void close() throws Exception {

    }
}
