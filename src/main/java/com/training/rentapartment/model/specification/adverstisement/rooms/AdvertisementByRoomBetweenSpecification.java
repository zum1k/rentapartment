package com.training.rentapartment.model.specification.adverstisement.rooms;

import com.training.rentapartment.model.Specification;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.model.SqlQueryParameter;
import com.training.rentapartment.model.specification.queryparameters.IntegerSqlQueryParameter;

import java.util.Arrays;
import java.util.List;

public class AdvertisementByRoomBetweenSpecification implements Specification {
    private final IntegerSqlQueryParameter lowerValue;
    private final IntegerSqlQueryParameter higherValue;

    public AdvertisementByRoomBetweenSpecification(int lowerBorder, int higherBorder) {
        this.lowerValue = new IntegerSqlQueryParameter(lowerBorder);
        this.higherValue = new IntegerSqlQueryParameter(higherBorder);
    }

    @Override
    public String toSqlRequest() {
        return " WHERE " + SqlConstant.ADVERTISEMENT_ROOMS + " > ? " +
                " AND WHERE " + SqlConstant.ADVERTISEMENT_ROOMS + " < ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(lowerValue, higherValue);
    }
}
