package com.training.rentapartment.model.repository.impl.advertisement;

import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.OwnerType;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlMapper;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.DoubleSqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.StringSqlQueryParameter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdvertisementSqlMapper implements SqlMapper<Advertisement> {

    @Override
    public List<Advertisement> toEntity(ResultSet resultSet) throws SQLException {
        List<Advertisement> queriedList = new ArrayList<>();
        while (resultSet.next()) {
            Advertisement advertisement = new Advertisement();
            advertisement.setAdId(resultSet.getInt(SqlConstant.ADVERTISEMENT_ID));
            advertisement.setCost(resultSet.getInt(SqlConstant.ADVERTISEMENT_COST));
            advertisement.setRooms(resultSet.getInt(SqlConstant.ADVERTISEMENT_ROOMS));
            advertisement.setFloor(resultSet.getInt(SqlConstant.ADVERTISEMENT_FLOOR));
            advertisement.setSquare(resultSet.getDouble(SqlConstant.ADVERTISEMENT_SQUARE));
            advertisement.setLivingSquare(resultSet.getDouble(SqlConstant.ADVERTISEMENT_LIVING_SQUARE));
            advertisement.setKitchenSquare(resultSet.getDouble(SqlConstant.ADVERTISEMENT_KITCHEN_SQUARE));
            advertisement.setOwner(OwnerType.valueOf(resultSet.getString(SqlConstant.ADVERTISEMENT_OWNER).toUpperCase()));
            advertisement.setPhoneNumber(resultSet.getString(SqlConstant.ADVERTISEMENT_PHONE));
            advertisement.setAddressId(resultSet.getInt(SqlConstant.ADDRESS_ID));
            advertisement.setUserId(resultSet.getInt(SqlConstant.USER_ID));
            advertisement.setDescription(resultSet.getString(SqlConstant.ADVERTISEMENT_DESCRIPTION));
            queriedList.add(advertisement);
        }
        return queriedList;
    }

    @Override
    public Map<String, SqlQueryParameter> toEntityFields(Advertisement advertisement) {
        Map<String, SqlQueryParameter> fields = new HashMap<>();
        fields.put(SqlConstant.ADVERTISEMENT_COST, new IntegerSqlQueryParameter(advertisement.getCost()));
        fields.put(SqlConstant.ADVERTISEMENT_ROOMS, new IntegerSqlQueryParameter(advertisement.getRooms()));
        fields.put(SqlConstant.ADVERTISEMENT_FLOOR, new IntegerSqlQueryParameter(advertisement.getFloor()));
        fields.put(SqlConstant.ADVERTISEMENT_SQUARE, new DoubleSqlQueryParameter(advertisement.getSquare()));
        fields.put(SqlConstant.ADVERTISEMENT_LIVING_SQUARE, new DoubleSqlQueryParameter(advertisement.getLivingSquare()));
        fields.put(SqlConstant.ADVERTISEMENT_KITCHEN_SQUARE, new DoubleSqlQueryParameter(advertisement.getKitchenSquare()));
        fields.put(SqlConstant.ADVERTISEMENT_OWNER, new StringSqlQueryParameter(advertisement.getOwner().toString()));
        fields.put(SqlConstant.ADVERTISEMENT_PHONE, new StringSqlQueryParameter(advertisement.getPhoneNumber()));
        fields.put(SqlConstant.ADDRESS_ID, new IntegerSqlQueryParameter(advertisement.getAddressId()));
        fields.put(SqlConstant.USER_ID, new IntegerSqlQueryParameter(advertisement.getUserId()));
        fields.put(SqlConstant.ADVERTISEMENT_DESCRIPTION, new StringSqlQueryParameter(advertisement.getDescription()));
        return fields;
    }
}
