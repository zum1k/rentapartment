package com.epam.training.rentapartment.command.impl;

import com.epam.training.rentapartment.command.Command;
import com.epam.training.rentapartment.command.impl.admin.DeleteUserCommand;
import com.epam.training.rentapartment.command.impl.guest.LogInCommand;
import com.epam.training.rentapartment.command.impl.guest.RegisterCommand;
import com.epam.training.rentapartment.command.impl.user.*;

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
