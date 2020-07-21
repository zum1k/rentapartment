package com.training.rentapartment.controller;

import javax.servlet.http.HttpServletRequest;

public interface EntityMapper<T> {
    T toEntity(HttpServletRequest request);
}
