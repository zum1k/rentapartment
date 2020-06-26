package com.epam.training.rentapartment.controller;

import com.epam.training.rentapartment.connection.ConnectionPool;
import com.epam.training.rentapartment.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
    private static final String REQUEST_PARAMETER_COMMAND = "command";

    public void init() {
        try {
            super.init();
        } catch (ServletException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override//TODO
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override//TODO
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/pages/client.jsp").forward(request, response);
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

    private void doProcess(HttpServletRequest request, HttpServletResponse response)  {//
    }
}
