package com.training.rentapartment.model.repository.specification.adverstisement;

import com.training.rentapartment.model.repository.Specification;
import com.training.rentapartment.model.repository.SqlQueryParameter;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementByFiltersSpecification implements Specification {
    private final List<Specification> specifications;
    public AdvertisementByFiltersSpecification(List<Specification> specifications) {
        this.specifications = specifications;
    }

    @Override
    public String toSqlRequest() {
        StringBuilder sqlRequest = new StringBuilder(" WHERE 1=1 ");
        for (Specification specification:specifications){
            sqlRequest.append(specification.toSqlRequest());
        }
        return sqlRequest.toString();
    }

    @Override
    public List<SqlQueryParameter> receiveParameters() {
        List<SqlQueryParameter> sqlQueryParameters = new ArrayList<>();
        for (Specification specification: specifications){
            sqlQueryParameters.addAll(specification.receiveParameters());
        }
        return sqlQueryParameters;
    }
}
