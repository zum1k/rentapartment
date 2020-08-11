package com.training.rentapartment.model.specification.image;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class ImageByAdvertisementIdSpecification implements Specification {
    private final IntegerSqlQueryParameter advertisementId;

    public ImageByAdvertisementIdSpecification(int advertisementId) {
        this.advertisementId = new IntegerSqlQueryParameter(advertisementId);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_ID + " = ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(advertisementId);
    }
}
