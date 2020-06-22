package com.epam.training.rentapartment.controller;

import com.epam.training.rentapartment.connection.ConnectionPool;
import com.epam.training.rentapartment.connection.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    public void init() {
        try {
            super.init();
        } catch (ServletException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        ConnectionPool connectionPool = ConnectionPool.getINSTANCE();
        try {
            connectionPool.closeConnections();
        } catch (ConnectionPoolException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
