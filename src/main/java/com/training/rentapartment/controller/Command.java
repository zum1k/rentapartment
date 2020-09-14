package com.training.rentapartment.controller;

import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
/**
 * This interface is basis of any command in the application. The method {@code execute} should contain code of
 * the processing of the parameters passed in the http request.
 */

public interface Command {
    /**
     * @param request http request
     * @param response http response
     * @return instance of {@code CommandResult} class, which is stands for target for forward or redirect after command
     * @throws CommandException if some unforeseen circumstances arose in the code
     */
    CommandResult execute(HttpServletRequest request) throws CommandException;
}
