package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteAccountCommand implements Command {
    private final UserServiceImpl service;

    public DeleteAccountCommand() {
        this.service = UserServiceImpl.getINSTANCE();
    }

    public DeleteAccountCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        int userId = Integer.parseInt(request.getParameter(HttpRequestParameters.USER_ID));
        try {
            service.deleteAccount(userId);
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new CommandException(e.getMessage(), e);
        }
        return CommandResult.redirect(PagePath.CLIENT);
    }
}
