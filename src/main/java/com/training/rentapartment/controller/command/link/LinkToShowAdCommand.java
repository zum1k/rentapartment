package com.training.rentapartment.controller.command.link;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class LinkToShowAdCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        return null;
    }
}