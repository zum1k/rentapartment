package com.training.rentapartment.model.specification.image;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class ImageByIdSpecification implements Specification {
    private final IntegerSqlQueryParameter imageId;

    public ImageByIdSpecification(int imageId) {
        this.imageId = new IntegerSqlQueryParameter(imageId);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.IMAGES_ID + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(imageId);
    }
}
