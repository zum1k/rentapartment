package com.training.rentapartment.controller.command;

import com.training.rentapartment.controller.command.admin.AllUsersCommand;
import com.training.rentapartment.controller.command.admin.DeleteUserCommand;
import com.training.rentapartment.controller.command.guest.AllAdvertisementsCommand;
import com.training.rentapartment.controller.Command;
import com.training.rentapartment.controller.command.guest.LogInCommand;
import com.training.rentapartment.controller.command.guest.RegisterCommand;
import com.training.rentapartment.controller.command.guest.VerificationCommand;
import com.training.rentapartment.controller.command.user.*;

public class CommandFactory {
    public Command createCommand(String commandName) {
        Command command = null;

        switch (commandName) {
            //guest commands
            case "login":
                command = new LogInCommand();
                break;
            case "register":
                command = new RegisterCommand();
                break;
            case "verification":
                command = new VerificationCommand();
                break;
            case "show_all_advertisements":
                command = new AllAdvertisementsCommand();

            //user commands
            case "delete_account":
                command = new DeleteAccountCommand();
                break;
            case "add_ad":
                command = new AddAdvertisementCommand();
                break;
            case "delete_ad":
                command = new DeleteAdCommand();
                break;
            case "logout":
                command = new LogOutCommand();
                break;
            case "show_user_ad":
                command = new ShowUserAdCommand();
                break;

            //admin commands
            case "delete_user":
                command = new DeleteUserCommand();
                break;
            case "show_all_users":
                command = new AllUsersCommand();
        }
        return command;
    }
}
