package com.epam.training.rentapartment.specification;

import java.util.List;

public interface Specification<T> {
    String toSqlRequest();
    List<T> receiveParameters();
}
