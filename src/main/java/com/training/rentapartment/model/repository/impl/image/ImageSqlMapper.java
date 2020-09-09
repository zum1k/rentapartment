package com.training.rentapartment.model.repository.impl.image;

import com.training.rentapartment.entity.Image;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlMapper;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.InputStreamSqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.StringSqlQueryParameter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageSqlMapper implements SqlMapper<Image> {

    @Override
    public List<Image> toEntity(ResultSet resultSet) throws SQLException {
        List<Image> queriedList = new ArrayList<>();
        while (resultSet.next()) {
            Image image = new Image();
            image.setImageId(resultSet.getInt(SqlConstant.IMAGES_ID));
            image.setAdId(resultSet.getInt(SqlConstant.ADVERTISEMENT_ID));
            image.setImageURL(resultSet.getString(SqlConstant.IMAGES_IMAGE_URL));
            image.setImageData(extractBytes(resultSet));
            queriedList.add(image);
        }
        return queriedList;
    }

    @Override
    public Map<String, SqlQueryParameter> toEntityFields(Image image) {
        Map<String, SqlQueryParameter> fields = new HashMap<>();
        fields.put(SqlConstant.ADVERTISEMENT_ID, new IntegerSqlQueryParameter(image.getAdId()));
        fields.put(SqlConstant.IMAGES_IMAGE_URL, new StringSqlQueryParameter(image.getImageURL()));
        fields.put(SqlConstant.IMAGES_IMAGE_DATA, new InputStreamSqlQueryParameter(convertBytesToStream(image.getImageData())));
        return fields;
    }

    private byte[] extractBytes(ResultSet resultSet) {
        Blob blob = null;
        byte[] bytes = null;
        try {
            blob = resultSet.getBlob(SqlConstant.IMAGES_IMAGE_DATA);
            bytes = blob.getBytes(1, (int) blob.length());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return bytes;
    }

    private InputStream convertBytesToStream(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }
}
