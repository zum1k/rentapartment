package com.training.rentapartment.model.repository.address;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.model.SqlEntityConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AddressMapperImpl implements SqlEntityConverter<Address> {

    @Override
    public List<Address> toEntity(ResultSet resultSet) throws SQLException {
        return null;
    }
    @Override
    public Map<String, Object> toEntityFields(Address address) {
        return null;
    }
}
