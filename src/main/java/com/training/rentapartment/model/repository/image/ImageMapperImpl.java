package com.training.rentapartment.model.repository.image;

import com.training.rentapartment.entity.Image;
import com.training.rentapartment.model.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImageMapperImpl implements EntityMapper<Image> {

    @Override
    public List<Image> toEntity(ResultSet resultSet) throws SQLException {
        return null;
    }
}
