package com.training.rentapartment.controller.command.impl.guest;

import com.training.rentapartment.controller.command.Command;
import com.training.rentapartment.service.GuestService;

import javax.servlet.http.HttpServletRequest;

public class VerificationCommand implements Command {
    private GuestService service;

    public VerificationCommand() {
        this.service = GuestService.getINSTANCE();
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    } //TODO
}
