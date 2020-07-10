package com.training.rentapartment.controller.command.impl;

import com.training.rentapartment.controller.command.Command;
import com.training.rentapartment.controller.command.impl.admin.DeleteUserCommand;
import com.training.rentapartment.controller.command.impl.guest.LogInCommand;
import com.training.rentapartment.controller.command.impl.guest.RegisterCommand;
import com.epam.training.rentapartment.controller.command.impl.user.*;
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

            //user commands
            case "delete account":
                command = new DeleteAccountCommand();
                break;
            case "add ad":
                command = new AddAdCommand();
                break;
            case "delete ad":
                command = new DeleteAdCommand();
                break;
            case "logout":
                command = new LogOutCommand();
                break;
            case "show user ad":
                command = new ShowUserAdCommand();
                break;

            //admin commands
            case "delete user":
                command = new DeleteUserCommand();
                break;
        }
        return command;
    }
}
