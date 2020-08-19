package com.training.rentapartment.model.repository.specification.image;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

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
