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
        switch (commandName) {
            //guest commands
            case "login":
                return new LogInCommand();
            case "register":
                return new RegisterCommand();
            case "verification":
                return new VerificationCommand();
            case "show_all_advertisements":
                return new AllAdvertisementsCommand();
            case "show_advertisement":
                return new ShowAdvertisementCommand();
            case "show_all_advertisements_by_filter":
                return new AllAdvertisementsByQueryCommand();
            //user commands
            case "delete_account":
                return new DeleteAccountCommand();
            case "add_ad":
                return new AddAdvertisementCommand();
            case "delete_ad":
                return new DeleteAdCommand();
            case "logout":
                return new LogOutCommand();
            case "show_user_ad":
                return new ShowUserAdvertisementsCommand();
            case "upload_images":
                return new UploadImagesCommand();
            //admin commands
            case "delete_user":
                return new DeleteUserCommand();
            case "show_all_users":
                return new AllUsersCommand();
            case "show_admins":
                return new AllAdminsCommand();
            case "register_admin":
                return new RegisterAdminCommand();
            //link commands
            case "link_to_register":
                return new LinkToRegisterPageCommand();
            case "link_to_show_ad":
                return new LinkToShowAdCommand();
            case "link_to_main":
                return new LinkToMainPageCommand();
            case "link_to_all_users":
                return new LinkToAllUsersCommand();
            case "link_to_add_ad":
                return new LinkToAddAdPageCommand();
            case "link_to_login":
                return new LinkToLoginPageCommand();
            case "link_to_upload_images":
                return new LinkToUploadImagesCommand();
            default:
                return new AllAdvertisementsCommand();
        }
    }
}
