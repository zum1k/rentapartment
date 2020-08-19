package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.model.repository.impl.user.UserRepository;
import com.training.rentapartment.service.impl.GuestServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class VerificationCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(VerificationCommand.class);
    private GuestServiceImpl service;

    public VerificationCommand() {
        this.service = GuestServiceImpl.getInstance();
    }

    @Override
    public CommandResult execute(HttpServletRequest request) { //TODO
        String page = PagePath.VERIFICATION;
        return CommandResult.redirect(page);
    }
}
