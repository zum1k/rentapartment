package com.training.rentapartment.controller.command.admin;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command {
    private final UserService service;

    public DeleteUserCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter(HttpRequestParameters.USER_ID));
        return null;
    }
}
