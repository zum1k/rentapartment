package com.training.rentapartment.exception;

public class CommandException extends Exception {
    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable e) {
        super(message, e);
    }

    public CommandException(Throwable e) {
        super(e);
    }
}
