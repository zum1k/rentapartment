package com.training.rentapartment.model.specification.adverstisement;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByIdSpecification implements Specification {
    private final int adId;

    public AdvertisementByIdSpecification(int adId) {
        this.adId = adId;
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_ID + " = ?";
    }

    @Override
    public List<Object> receiveParameters() {
        return Arrays.asList(adId);
    }
}
