package com.epam.training.rentapartment.exception;

import java.sql.SQLException;

public class ConnectionPoolException extends Throwable {
    public ConnectionPoolException(String message, SQLException e) {
    }
}
