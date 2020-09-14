package com.training.rentapartment.controller.command.access;

import com.training.rentapartment.controller.command.CommandType;
import com.training.rentapartment.entity.UserType;

public class CommandAccess {
    public static boolean matchCommandRole(String command, UserType role) {
        for (CommandType type : CommandType.values()) {
            if (type.getCommandValue().equals(command) && type.getRoles().contains(role)) {
                return true;
            }
        }
        return false;
    }
}
