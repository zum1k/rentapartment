package com.epam.training.rentapartment.repository.imp;

import com.epam.training.rentapartment.entity.Image;
import com.epam.training.rentapartment.repository.Repository;
import com.epam.training.rentapartment.repository.Specification;

import java.util.Comparator;
import java.util.List;

public class ImageRepository implements Repository<Image>, AutoCloseable { //TODO
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
    public List<Image> findAll() {
        return null;
    }

    @Override
    public List<Image> sort(Comparator<Image> comparator) {
        return null;
    }

    @Override
    public List<Image> query(Specification specification) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
