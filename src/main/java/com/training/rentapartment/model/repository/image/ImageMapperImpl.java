package com.training.rentapartment.model.repository.image;

import com.training.rentapartment.entity.Image;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlEntityConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageMapperImpl implements SqlEntityConverter<Image> {

    @Override
    public List<Image> toEntity(ResultSet resultSet) throws SQLException {
        List<Image> queriedList = new ArrayList<>();
        while (resultSet.next()) {
            Image image = new Image();
            image.setImageId(resultSet.getInt(SqlConstant.IMAGES_ID));
            image.setAdId(resultSet.getInt(SqlConstant.ADVERTISEMENT_ID));
            image.setImageURL(resultSet.getString(SqlConstant.IMAGES_IMAGE_URL));
            image.setImageData(resultSet.getBytes(SqlConstant.IMAGES_IMAGE_DATA));
            queriedList.add(image);
        }
        return queriedList;
    }

    @Override
    public Map<String, Object> toEntityFields(Image image) {
        Map<String, Object> fields = new HashMap<>();
        fields.put(SqlConstant.IMAGES_ID, image.getImageId());
        fields.put(SqlConstant.ADVERTISEMENT_ID, image.getAdId());
        fields.put(SqlConstant.IMAGES_IMAGE_URL, image.getImageURL());
        fields.put(SqlConstant.IMAGES_IMAGE_DATA, image.getImageData());
        return fields;
    }
}
