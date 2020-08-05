package com.training.rentapartment.controller;

import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    CommandResult execute(HttpServletRequest request) throws CommandException;
}
