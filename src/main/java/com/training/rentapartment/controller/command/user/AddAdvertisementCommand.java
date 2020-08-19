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
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AddAdvertisementCommand implements Command {

    private AdvertisementServiceImpl service;

    public AddAdvertisementCommand() {
        this.service = AdvertisementServiceImpl.getINSTANCE();
    }

    public AddAdvertisementCommand(AdvertisementServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException { //TODO
        String page = null;
        if (AdvertisementValidator.validateAdvertisementRequest(request)) {
            try {
                Image image = new ImageMapper().toEntity(request);
                Address address = new AddressMapper().toEntity(request);
                Advertisement advertisement = new AdvertisementMapper().toEntity(request);
                service.addAdvertisement(advertisement, address, Collections.singletonList(image)); //todo change
                page = PagePath.CLIENT;
            } catch (ServletException | ServiceException |IOException e) {
                throw new CommandException(e.getMessage(), e);
            }
        } else {
            page = PagePath.ADD_ADVERTISEMENT;
        }
        return CommandResult.redirect(page);
    }

    private List<Image> parseImagesFromRequest(HttpServletRequest request) {
        return Collections.emptyList();
    }
}
