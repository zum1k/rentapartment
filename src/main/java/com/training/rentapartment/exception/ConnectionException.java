package com.training.rentapartment.exception;

public class ConnectionException extends Exception {
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable e) {
        super(message, e);
    }

    public ConnectionException(Throwable e) {
        super(e);
    }
}
