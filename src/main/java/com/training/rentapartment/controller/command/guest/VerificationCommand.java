package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.service.GuestService;

import javax.servlet.http.HttpServletRequest;

public class VerificationCommand implements Command {
    private GuestService service;

    public VerificationCommand() {
        this.service = GuestService.getINSTANCE();
    }

    @Override
    public String execute(HttpServletRequest request) { //TODO
        String page = PagePath.VERIFICATION;
        return page;
    }
}
