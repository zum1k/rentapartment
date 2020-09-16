package com.training.rentapartment.controller.command;

public class PagePath {
    public static final String INDEX = "index.jsp";
    public static final String MAIN = "WEB-INF/pages/main.jsp";
    public static final String LOGIN = "WEB-INF/pages/login.jsp";
    public static final String ADVERTISEMENT = "WEB-INF/pages/advertisement.jsp";
    public static final String EXCEPTION = "WEB-INF/pages/exception.jsp";
    public static final String REGISTRATION = "WEB-INF/pages/register.jsp";
    public static final String CLIENT = "WEB-INF/pages/client.jsp";
    public static final String VERIFICATION = "WEB-INF/pages/verification.jsp";
    public static final String ADD_ADVERTISEMENT = "WEB-INF/pages/add_advertisement.jsp";
    public static final String USERS = "WEB-INF/pages/users.jsp";
    public static final String IMAGES = "WEB-INF/pages/upload_images.jsp";
    public static final String REGISTER_ADMIN = "WEB-INF/pages/register_admin.jsp";
    public static final String ADMINS = "WEB-INF/pages/admins.jsp";
    //links
    public static final String LINK_TO_MAIN = "/controller?command=show_all_advertisements";
    public static final String LINK_TO_CLIENT = "/controller?command=show_all_advertisements";
    public static final String LINK_TO_UPLOAD_IMAGE = "/controller?command=show_all_advertisements";
    private PagePath() {
    }
}
