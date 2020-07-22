package com.training.rentapartment.model.repository.advertisement;

import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.OwnerType;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlMapper;

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
            advertisement.setAdDate(resultSet.getString(SqlConstant.ADVERTISEMENT_DATE));
            advertisement.setUserId(resultSet.getInt(SqlConstant.USER_ID));
            advertisement.setDescription(resultSet.getString(SqlConstant.ADVERTISEMENT_DESCRIPTION));
            queriedList.add(advertisement);
        }
        return queriedList;
    }

    @Override
    public Map<String, Object> toEntityFields(Advertisement advertisement) {
        Map<String, Object> fields = new HashMap<>();
        fields.put(SqlConstant.ADVERTISEMENT_ID, advertisement.getAdId());
        fields.put(SqlConstant.ADVERTISEMENT_COST, advertisement.getCost());
        fields.put(SqlConstant.ADVERTISEMENT_ROOMS, advertisement.getRooms());
        fields.put(SqlConstant.ADVERTISEMENT_FLOOR, advertisement.getFloor());
        fields.put(SqlConstant.ADVERTISEMENT_SQUARE, advertisement.getSquare());
        fields.put(SqlConstant.ADVERTISEMENT_LIVING_SQUARE, advertisement.getLivingSquare());
        fields.put(SqlConstant.ADVERTISEMENT_KITCHEN_SQUARE, advertisement.getKitchenSquare());
        fields.put(SqlConstant.ADVERTISEMENT_OWNER, advertisement.getOwner());
        fields.put(SqlConstant.ADVERTISEMENT_PHONE, advertisement.getPhoneNumber());
        fields.put(SqlConstant.ADVERTISEMENT_DATE, advertisement.getAdDate());
        fields.put(SqlConstant.USER_ID, advertisement.getUserId());
        fields.put(SqlConstant.ADVERTISEMENT_DESCRIPTION, advertisement.getDescription());
        return fields;
    }
}
