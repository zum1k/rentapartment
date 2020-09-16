package com.training.rentapartment.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface EntityMapper<T> {
    T toEntity(HttpServletRequest request) throws IOException, ServletException;

    List<T> toEntityList(HttpServletRequest request) throws IOException, ServletException;
}
