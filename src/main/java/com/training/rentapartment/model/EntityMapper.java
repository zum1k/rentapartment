package com.training.rentapartment.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EntityMapper<T> {
    List<T> toEntity(ResultSet resultSet) throws SQLException;
    Map<String, Object> toEntityFields(T t);
}
