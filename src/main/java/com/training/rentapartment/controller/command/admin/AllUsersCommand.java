package com.training.rentapartment.controller.command.admin;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.entity.User;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.UserService;
import com.training.rentapartment.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AllUsersCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(AllUsersCommand.class);
    private UserService service;


    public AllUsersCommand() {
        this.service = new UserServiceImpl();
    }

    public AllUsersCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String page = PagePath.MAIN;
        try {
            List<User> users = service.findAllClientUsers();
            request.setAttribute(HttpRequestParameters.USERS, users);
            page = PagePath.USERS;
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            throw new CommandException(e.getMessage(), e);
        }
        return CommandResult.forward(page);
    }
}
