package com.training.rentapartment.model.repository.specification.adverstisement.rooms;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlConstant;
import com.training.rentapartment.model.repository.SqlQueryParameter;
import com.training.rentapartment.model.repository.specification.queryparameters.IntegerSqlQueryParameter;

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
        return " AND " + SqlConstant.ADVERTISEMENT_ROOMS + " >= ? " +
                " AND " + SqlConstant.ADVERTISEMENT_ROOMS + " <= ?";
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        return Arrays.asList(lowerValue, higherValue);
    }
}
