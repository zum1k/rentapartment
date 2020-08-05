package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.service.GuestService;

import javax.servlet.http.HttpServletRequest;

public class AllAdvertisementsCommand implements Command {
    private GuestService service;


    public AllAdvertisementsCommand() {
        this.service = GuestService.getINSTANCE();
    }

    public AllAdvertisementsCommand(GuestService service) {
        this.service = service;
    }
    @Override
    public CommandResult execute(HttpServletRequest request) {
        return CommandResult.redirect(PagePath.MAIN);
    }
}
