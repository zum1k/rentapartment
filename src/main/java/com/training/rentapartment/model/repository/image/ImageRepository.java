package com.training.rentapartment.model.repository.image;

import com.training.rentapartment.entity.Image;
import com.training.rentapartment.model.Repository;
import com.training.rentapartment.model.Specification;

import java.util.List;
import java.util.Optional;

public class ImageRepository implements Repository<Image>, AutoCloseable {
    @Override
    public void add(Image image) {

    }

    @Override
    public void remove(Image image) {

    }

    @Override
    public void update(Image image) {

    }

    @Override
    public List<Image> query(Specification specification) {
        return null;
    }

    @Override
    public Optional<Image> singleQuery(Specification specification) {
        return Optional.empty();
    }

    @Override
    public void close() throws Exception {

    } //TODO

}
