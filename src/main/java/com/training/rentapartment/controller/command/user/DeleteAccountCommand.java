package com.training.rentapartment.controller.command.user;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.CommandResult;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.model.SqlConstant;
import com.training.rentapartment.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class DeleteAccountCommand implements Command {
    private final UserService service;

    public DeleteAccountCommand() {
        this.service = UserService.getINSTANCE();
    }

    public DeleteAccountCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) {
        String page = PagePath.CLIENT;
        int userId = Integer.parseInt(request.getParameter(SqlConstant.USER_ID));
        if (service.deleteAccount(userId)) {
            page = PagePath.MAIN;
        }
        return CommandResult.redirect(page);
    }
}
