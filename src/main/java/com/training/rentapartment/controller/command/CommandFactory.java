package com.training.rentapartment.controller.command;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.admin.AllAdminsCommand;
import com.training.rentapartment.controller.command.admin.AllUsersCommand;
import com.training.rentapartment.controller.command.admin.DeleteUserCommand;
import com.training.rentapartment.controller.command.admin.RegisterAdminCommand;
import com.training.rentapartment.controller.command.guest.*;
import com.training.rentapartment.controller.command.link.*;
import com.training.rentapartment.controller.command.user.*;

public class CommandFactory {
    public Command createCommand(String commandName) {
        CommandType commandType = null;
        for (CommandType type : CommandType.values()) {
            if (type.getCommandValue().equals(commandName)) {
                commandType = type;
            }
        }
        if (commandType == null) {
            return new AllAdvertisementsCommand();
        }

        switch (commandType) {
            //guest commands
            case SET_LOCALE:
                return new SetLocaleCommand();
            case LOGIN:
                return new LogInCommand();
            case REGISTER:
                return new RegisterCommand();
            case SHOW_ALL_ADVERTISEMENTS:
                return new AllAdvertisementsCommand();
            case SHOW_ADVERTISEMENT:
                return new ShowAdvertisementCommand();
            case SHOW_ADVERTISEMENTS_BY_FILTER:
                return new AllAdvertisementsByQueryCommand();
            //user commands
            case DELETE_ACCOUNT:
                return new DeleteAccountCommand();
            case ADD_AD:
                return new AddAdvertisementCommand();
            case DELETE_AD:
                return new DeleteAdCommand();
            case LOGOUT:
                return new LogOutCommand();
            case SHOW_USER_AD:
                return new ShowUserAdvertisementsCommand();
            case UPLOAD_IMAGES:
                return new UploadImagesCommand();
            //admin commands
            case DELETE_USER:
                return new DeleteUserCommand();
            case SHOW_ALL_USERS:
                return new AllUsersCommand();
            case SHOW_ADMINS:
                return new AllAdminsCommand();
            case REGISTER_ADMIN:
                return new RegisterAdminCommand();
            //link commands
            case LINK_TO_REGISTER:
                return new LinkToRegisterPageCommand();
            case LINK_TO_SHOW_AD:
                return new LinkToShowAdCommand();
            case LINK_TO_MAIN:
                return new LinkToMainPageCommand();
            case LINK_TO_ALL_USERS:
                return new LinkToAllUsersCommand();
            case LINK_TO_ADD_AD:
                return new LinkToAddAdPageCommand();
            case LINK_TO_LOGIN:
                return new LinkToLoginPageCommand();
            case LINK_TO_UPLOAD_IMAGES:
                return new LinkToUploadImagesCommand();
            case LINK_TO_REGISTER_ADMIN:
                return new LinkToRegisterAdminPageCommand();
            default:
                return new AllAdvertisementsCommand();
        }
    }
}
