package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.AddressMapper;
import com.training.rentapartment.controller.mapper.AdvertisementMapper;
import com.training.rentapartment.controller.mapper.ImageMapper;
import com.training.rentapartment.controller.validator.AdvertisementValidator;
import com.training.rentapartment.entity.Address;
import com.training.rentapartment.entity.Advertisement;
import com.training.rentapartment.entity.Image;
import com.training.rentapartment.service.AdvertisementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AddAdvertisementCommand implements Command {
    private static final String SPACE_APPENDER = " ";

    private AdvertisementService service;


    public AddAdvertisementCommand() {
        this.service = AdvertisementService.getINSTANCE();
    }

    public AddAdvertisementCommand(AdvertisementService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) { //TODO
        String page = null;
        if (AdvertisementValidator.validateAdvertisementRequest(request)) {
            try {
                Image image = new ImageMapper().toEntity(request);
                Address address = new AddressMapper().toEntity(request);
                Advertisement advertisement = new AdvertisementMapper().toEntity(request);
                service.addAdvertisement(advertisement, address, image);
                page = PagePath.CLIENT;
            } catch (IOException | ServletException e) {
                return CommandResult.forward(PagePath.EXCEPTION);
            }
        } else {
            page = PagePath.ADD_ADVERTISEMENT;
        }
        return CommandResult.redirect(page);
    }
}
