package com.epam.training.rentapartment.command.impl.user;

import com.epam.training.rentapartment.command.Command;
import com.epam.training.rentapartment.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.MAIN;
    }
}
