package com.epam.training.rentapartment.connection;

import java.sql.SQLException;

public class ConnectionPoolException extends Throwable {
    public ConnectionPoolException(String message, SQLException e) {
    }
}
