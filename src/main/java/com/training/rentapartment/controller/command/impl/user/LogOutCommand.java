package com.training.rentapartment.controller.command.impl.user;

import com.training.rentapartment.controller.command.Command;
import com.training.rentapartment.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return PagePath.MAIN;
    }
}
