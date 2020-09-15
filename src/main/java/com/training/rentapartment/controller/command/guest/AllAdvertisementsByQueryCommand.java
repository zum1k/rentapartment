package com.training.rentapartment.controller.command.guest;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.mapper.AdvertisementQueryDtoMapper;
import com.training.rentapartment.controller.validator.AdvertisementQueryDtoValidator;
import com.training.rentapartment.entity.dto.AdvertisementDto;
import com.training.rentapartment.entity.dto.AdvertisementQueryDto;
import com.training.rentapartment.exception.CommandException;
import com.training.rentapartment.exception.ServiceException;
import com.training.rentapartment.service.AdvertisementService;
import com.training.rentapartment.service.impl.AdvertisementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class AllAdvertisementsByQueryCommand implements Command {
    private final AdvertisementService service;

    public AllAdvertisementsByQueryCommand() {
        this.service = new AdvertisementServiceImpl();
    }

    public AllAdvertisementsByQueryCommand(AdvertisementServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        AdvertisementQueryDtoValidator validator = new AdvertisementQueryDtoValidator();
        if (validator.validateAdvertisementQueryDto(request)) {
            try {
                AdvertisementQueryDtoMapper mapper = new AdvertisementQueryDtoMapper();
                AdvertisementQueryDto queryDto = mapper.toEntity(request);
                List<AdvertisementDto> dtos = service.findAdvertisementsByFilters(queryDto);
                request.setAttribute(HttpRequestParameters.ADVERTISEMENTS, dtos);
            } catch (IOException | ServletException | ServiceException e) {
                e.printStackTrace();
                throw new CommandException(e.getMessage(), e);
            }
        }
        return CommandResult.forward(PagePath.MAIN);
    }
}
