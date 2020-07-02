package com.epam.training.rentapartment.specification;

import java.util.List;

public interface Specification {
    String toSqlRequest();
    List<String> receiveParameters();
}
