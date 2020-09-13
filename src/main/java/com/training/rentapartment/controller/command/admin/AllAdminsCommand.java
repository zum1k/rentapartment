package com.training.rentapartment.controller.command.admin;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AllAdminsCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AllAdminsCommand.class);
    private UserServiceImpl service;

    public AllAdminsCommand(UserServiceImpl service) {
        this.service = service;
    }

    public AllAdminsCommand() {
        this.service = UserServiceImpl.getInstance();
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String page = PagePath.LINK_TO_MAIN;
        try {
            List<User> users = service.findAllAdminUsers();
            request.setAttribute(HttpRequestParameters.USERS, users);
            page = PagePath.USERS;
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            throw new CommandException(e.getMessage(), e);
        }
        return CommandResult.forward(page);
    }
}
