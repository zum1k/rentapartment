package com.training.rentapartment.model.repository.impl.address;

import com.training.rentapartment.entity.Address;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlMapper;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.StringSqlQueryParameter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressSqlMapper implements SqlMapper<Address> {

    @Override
    public List<Address> toEntity(ResultSet resultSet) throws SQLException {
        List<Address> queriedList = new ArrayList<>();
        while (resultSet.next()) {
            Address address = new Address();
            address.setAddressId(resultSet.getInt(SqlConstant.ADDRESS_ID));
            address.setCity(resultSet.getString(SqlConstant.ADDRESS_CITY));
            address.setStreet(resultSet.getString(SqlConstant.ADDRESS_STREET));
            address.setHouseNumber(resultSet.getInt(SqlConstant.ADDRESS_HOUSE_NUMBER));
            address.setHouseIndex(resultSet.getInt(SqlConstant.ADDRESS_HOUSE_INDEX));
            queriedList.add(address);
        }
        return queriedList;
    }

    @Override
    public Map<String, SqlQueryParameter> toEntityFields(Address address) {
        Map<String, SqlQueryParameter> fields = new HashMap<>();
        fields.put(SqlConstant.ADDRESS_CITY, new StringSqlQueryParameter(address.getCity()));
        fields.put(SqlConstant.ADDRESS_STREET, new StringSqlQueryParameter(address.getStreet()));
        fields.put(SqlConstant.ADDRESS_HOUSE_NUMBER, new IntegerSqlQueryParameter(address.getHouseNumber()));
        fields.put(SqlConstant.ADDRESS_HOUSE_INDEX, new IntegerSqlQueryParameter(address.getHouseIndex()));
        return fields;
    }
}
