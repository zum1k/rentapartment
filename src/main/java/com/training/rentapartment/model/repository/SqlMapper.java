package com.training.rentapartment.model.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SqlMapper<T> {
    List<T> toEntity(ResultSet resultSet) throws SQLException;
    Map<String, SqlQueryParameter> toEntityFields(T t);
}
