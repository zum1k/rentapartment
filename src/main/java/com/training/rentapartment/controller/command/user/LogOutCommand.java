package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return CommandResult.redirect(PagePath.MAIN);
    }
}
