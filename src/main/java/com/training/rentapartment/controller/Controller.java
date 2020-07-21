package com.training.rentapartment.controller;

import com.training.rentapartment.controller.command.CommandFactory;
import com.training.rentapartment.exception.ConnectionPoolException;
import com.training.rentapartment.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/controller")
@MultipartConfig(maxFileSize = 16172216)
public class Controller extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
    private static final String REQUEST_PARAMETER_COMMAND = "command";
    private static final String ERROR_PARAMETER = "error";

    public void init() {
        try {
            super.init();
        } catch (ServletException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override//TODO
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override//TODO
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
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

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = new CommandFactory();
        String commandType = request.getParameter(REQUEST_PARAMETER_COMMAND);
        Command command = commandFactory.createCommand(commandType);

        String page = command.execute(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }
}


