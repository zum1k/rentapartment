package com.training.rentapartment.controller.command;

public class CommandResult {
    public enum RequestType {
        FORWARD,
        REDIRECT
    }

    private final String page;
    private final RequestType type;

    private CommandResult(String page, RequestType type) {
        this.page = page;
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public RequestType getRequestType() {
        return type;
    }

    public static CommandResult forward(String page) {
        return new CommandResult(page, RequestType.FORWARD);
    }

    public static CommandResult redirect(String page) {
        return new CommandResult(page, RequestType.REDIRECT);
    }
}
