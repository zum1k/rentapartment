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
        if (commandName == null) {
            return new AllAdvertisementsCommand();
        }
        if (CommandType.LOGIN.getCommandValue().equals(commandName)) {
            return new LogInCommand();
        }
        if (CommandType.REGISTER.getCommandValue().equals(commandName)) {
            return new RegisterCommand();
        }
        if (CommandType.SHOW_ALL_ADVERTISEMENTS.getCommandValue().equals(commandName)) {
            return new AllAdvertisementsCommand();
        }
        if (CommandType.SHOW_ADVERTISEMENT.getCommandValue().equals(commandName)) {
            return new ShowAdvertisementCommand();
        }
        if (CommandType.SHOW_ADVERTISEMENTS_BY_FILTER.getCommandValue().equals(commandName)) {
            return new AllAdvertisementsByQueryCommand();
        }
        if (CommandType.DELETE_ACCOUNT.getCommandValue().equals(commandName)) {
            return new DeleteAccountCommand();
        }
        if (CommandType.ADD_AD.getCommandValue().equals(commandName)) {
            return new AddAdvertisementCommand();
        }
        if (CommandType.DELETE_AD.getCommandValue().equals(commandName)) {
            return new DeleteAdCommand();
        }
        if (CommandType.LOGOUT.getCommandValue().equals(commandName)) {
            return new LogOutCommand();
        }
        if (CommandType.SHOW_USER_AD.getCommandValue().equals(commandName)) {
            return new ShowUserAdvertisementsCommand();
        }
        if (CommandType.UPLOAD_IMAGES.getCommandValue().equals(commandName)) {
            return new UploadImagesCommand();
        }
        if (CommandType.DELETE_USER.getCommandValue().equals(commandName)) {
            return new DeleteUserCommand();
        }
        if (CommandType.SHOW_ALL_USERS.getCommandValue().equals(commandName)) {
            return new AllUsersCommand();
        }
        if (CommandType.SHOW_ADMINS.getCommandValue().equals(commandName)) {
            return new AllAdminsCommand();
        }
        if (CommandType.REGISTER_ADMIN.getCommandValue().equals(commandName)) {
            return new RegisterAdminCommand();
        }
        if (CommandType.LINK_TO_REGISTER.getCommandValue().equals(commandName)) {
            return new LinkToRegisterPageCommand();
        }
        if (CommandType.LINK_TO_SHOW_AD.getCommandValue().equals(commandName)) {
            return new LinkToShowAdCommand();
        }
        if (CommandType.LINK_TO_MAIN.getCommandValue().equals(commandName)) {
            return new LinkToMainPageCommand();
        }
        if (CommandType.LINK_TO_ALL_USERS.getCommandValue().equals(commandName)) {
            return new LinkToAllUsersCommand();
        }
        if (CommandType.LINK_TO_ADD_AD.getCommandValue().equals(commandName)) {
            return new LinkToAddAdPageCommand();
        }
        if (CommandType.LINK_TO_LOGIN.getCommandValue().equals(commandName)) {
            return new LinkToLoginPageCommand();
        }
        if (CommandType.LINK_TO_UPLOAD_IMAGES.getCommandValue().equals(commandName)) {
            return new LinkToUploadImagesCommand();
        }
        if (CommandType.LINK_TO_REGISTER_ADMIN.getCommandValue().equals(commandName)) {
            return new LinkToRegisterAdminPageCommand();
        }
//        switch (commandName) {
//            //guest commands
//            case "login":
//                return new LogInCommand();
//            case "register":
//                return new RegisterCommand();
//            case "verification":
//                return new VerificationCommand();
//            case "show_all_advertisements":
//                return new AllAdvertisementsCommand();
//            case "show_advertisement":
//                return new ShowAdvertisementCommand();
//            case "show_all_advertisements_by_filter":
//                return new AllAdvertisementsByQueryCommand();
//            //user commands
//            case "delete_account":
//                return new DeleteAccountCommand();
//            case "add_ad":
//                return new AddAdvertisementCommand();
//            case "delete_ad":
//                return new DeleteAdCommand();
//            case "logout":
//                return new LogOutCommand();
//            case "show_user_ad":
//                return new ShowUserAdvertisementsCommand();
//            case "upload_images":
//                return new UploadImagesCommand();
//            //admin commands
//            case "delete_user":
//                return new DeleteUserCommand();
//            case "show_all_users":
//                return new AllUsersCommand();
//            case "show_admins":
//                return new AllAdminsCommand();
//            case "register_admin":
//                return new RegisterAdminCommand();
//            //link commands
//            case "link_to_register":
//                return new LinkToRegisterPageCommand();
//            case "link_to_show_ad":
//                return new LinkToShowAdCommand();
//            case "link_to_main":
//                return new LinkToMainPageCommand();
//            case "link_to_all_users":
//                return new LinkToAllUsersCommand();
//            case "link_to_add_ad":
//                return new LinkToAddAdPageCommand();
//            case "link_to_login":
//                return new LinkToLoginPageCommand();
//            case "link_to_upload_images":
//                return new LinkToUploadImagesCommand();
//            case "link_to_register_admin":
//                return new LinkToRegisterAdminPageCommand();
//            default:
//                return new AllAdvertisementsCommand();
//        }
        return new AllAdvertisementsCommand();
    }
}
