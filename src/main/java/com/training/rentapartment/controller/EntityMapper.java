package com.training.rentapartment.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface EntityMapper<T> {
    T toEntity(HttpServletRequest request) throws IOException, ServletException;
}
