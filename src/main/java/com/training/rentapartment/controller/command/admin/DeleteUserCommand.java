package com.training.rentapartment.controller.command.admin;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.validator.impl.NotNullValidator;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.UserService;
import com.training.rentapartment.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command {
    private final UserService service;

    public DeleteUserCommand() {
        this.service = new UserServiceImpl();
    }

    public DeleteUserCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        NotNullValidator validator = new NotNullValidator();
        String userIdRequest = request.getParameter(HttpRequestParameters.USER_ID);
        if (validator.validate(userIdRequest))
            try {
                int userId = Integer.parseInt(userIdRequest);
                service.deleteAccount(userId);
            } catch (ServiceException e) {
                e.printStackTrace();
                throw new CommandException(e.getMessage(), e);
            }
        return CommandResult.forward(PagePath.USERS);
    }
}
