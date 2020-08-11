package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.service.AdvertisementService;

import javax.servlet.http.HttpServletRequest;

public class AllAdvertisementsCommand implements Command {
    private AdvertisementService service;


    public AllAdvertisementsCommand() {
        this.service = AdvertisementService.getINSTANCE();
    }

    public AllAdvertisementsCommand(AdvertisementService service) {
        this.service = service;
    }
    @Override
    public CommandResult execute(HttpServletRequest request) {
        int advertisementNumbers =Integer.parseInt(request.getParameter(HttpRequestParameters.PAGE_COUNT));
        service.allAdvertisements();
        return CommandResult.redirect(PagePath.MAIN);
    }
}
