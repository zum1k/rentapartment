package com.training.rentapartment.controller.command;

import com.training.rentapartment.entity.UserType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CommandType {
    //guest commands
    LOGIN("login", Collections.singletonList(UserType.GUEST)),
    LINK_TO_LOGIN("link_to_login", Collections.singletonList(UserType.GUEST)),
    REGISTER("register", Collections.singletonList(UserType.GUEST)),
    LINK_TO_REGISTER("link_to_register", Collections.singletonList(UserType.GUEST)),
    //user commands
    DELETE_ACCOUNT("delete_account", Collections.singletonList(UserType.CLIENT)),
    ADD_AD("add_ad", Collections.singletonList(UserType.CLIENT)),
    LINK_TO_ADD_AD("link_to_add_ad", Collections.singletonList(UserType.CLIENT)),
    DELETE_AD("delete_ad", Collections.singletonList(UserType.CLIENT)),
    SHOW_USER_AD("show_user_ad", Collections.singletonList(UserType.CLIENT)),
    UPLOAD_IMAGES("upload_images", Collections.singletonList(UserType.CLIENT)),
    LINK_TO_UPLOAD_IMAGES("link_to_upload_images", Collections.singletonList(UserType.CLIENT)),
    //admin commands
    DELETE_USER("delete_user", Collections.singletonList(UserType.ADMIN)),
    SHOW_ALL_USERS("show_all_users", Collections.singletonList(UserType.ADMIN)),
    LINK_TO_ALL_USERS("link_to_all_users", Collections.singletonList(UserType.ADMIN)),
    SHOW_ADMINS("show_admins", Collections.singletonList(UserType.ADMIN)),
    REGISTER_ADMIN("register_admin", Collections.singletonList(UserType.ADMIN)),
    LINK_TO_REGISTER_ADMIN("link_to_register_admin", Collections.singletonList(UserType.ADMIN)),
    //client, admin commands
    LOGOUT("logout", Arrays.asList(UserType.CLIENT, UserType.ADMIN)),
    //common commands
    SHOW_ADVERTISEMENT("show_advertisement", Arrays.asList(UserType.ADMIN, UserType.GUEST, UserType.CLIENT)),
    SHOW_ADVERTISEMENTS_BY_FILTER("show_all_advertisements_by_filter", Arrays.asList(UserType.ADMIN, UserType.GUEST, UserType.CLIENT)),
    SHOW_ALL_ADVERTISEMENTS("show_all_advertisements", Arrays.asList(UserType.ADMIN, UserType.GUEST, UserType.CLIENT)),
    LINK_TO_SHOW_AD("link_to_show_ad", Arrays.asList(UserType.ADMIN, UserType.GUEST, UserType.CLIENT)),
    LINK_TO_MAIN("link_to_main", Arrays.asList(UserType.ADMIN, UserType.GUEST, UserType.CLIENT));

    private final String commandValue;
    private final List<UserType> roles;

    CommandType(String commandValue, List<UserType> types) {
        this.commandValue = commandValue;
        this.roles = types;
    }

    public String getCommandValue() {
        return commandValue;
    }

    public List<UserType> getRoles() {
        return roles;
    }
}
