package com.training.rentapartment.controller.command.impl;

import com.training.rentapartment.controller.command.Command;
import com.training.rentapartment.controller.command.impl.admin.DeleteUserCommand;
import com.training.rentapartment.controller.command.impl.guest.LogInCommand;
import com.training.rentapartment.controller.command.impl.guest.RegisterCommand;
import com.training.rentapartment.controller.command.impl.guest.ShowAllAdvertisementsCommand;
import com.training.rentapartment.controller.command.impl.guest.VerificationCommand;
import com.training.rentapartment.controller.command.impl.user.*;

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
                command = new ShowAllAdvertisementsCommand();

            //user commands
            case "delete_account":
                command = new DeleteAccountCommand();
                break;
            case "add_ad":
                command = new AddAdCommand();
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
        }
        return command;
    }
}
