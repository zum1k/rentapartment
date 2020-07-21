package com.training.rentapartment.model.repository.advertisement;

import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.model.SqlEntityConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class AdvertisementMapperImpl implements SqlEntityConverter<Advertisement> {

    @Override
    public List<Advertisement> toEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Map<String, Object> toEntityFields(Advertisement advertisement) {
        return null;
    }
}
