package com.training.rentapartment.exception;

import java.sql.SQLException;

public class ConnectionPoolException extends Exception {
    public ConnectionPoolException(String message, SQLException e) {
    }
}
