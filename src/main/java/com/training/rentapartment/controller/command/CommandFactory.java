package com.training.rentapartment.controller.command;

import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.admin.AllUsersCommand;
import com.training.rentapartment.controller.command.admin.DeleteUserCommand;
import com.training.rentapartment.controller.command.guest.AllAdvertisementsCommand;
import com.training.rentapartment.controller.command.guest.LogInCommand;
import com.training.rentapartment.controller.command.guest.RegisterCommand;
import com.training.rentapartment.controller.command.guest.VerificationCommand;
import com.training.rentapartment.controller.command.user.*;

public class CommandFactory {
    public Command createCommand(String commandName) {
        if (commandName == null) {
            return new AllUsersCommand();
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
               return new ShowUserAdCommand();
            //admin commands
            case "delete_user":
                return new DeleteUserCommand();
            case "show_all_users":
               return new AllUsersCommand();
            default:
                return new AllUsersCommand();
        }
    }
}
