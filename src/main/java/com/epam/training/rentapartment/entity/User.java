package com.epam.training.rentapartment.entity;

import java.util.Objects;

public class User {
    public static final String USER_TABLE_NAME = "users";

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String USER_ID = "user_id";
    public static final String TYPE = "type";

    private long userId;
    private UserType type;
    private String login;
    private String password;
    private String email;

    public User() {
    }

    public User(long id, UserType type, String login, String password, String email) {
        this.userId = id;
        this.type = type;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return userId;
    }

    public void setId(long id) {
        this.userId = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return userId == user.userId &&
                type == user.type &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, type, login, password, email); //TODO
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User{" + "id=").append(userId).append(", type=")
                .append(type).append(", login='").append(login).append('\'')
                .append(", password='").append(password).append('\'')
                .append(", email='").append(email)
                .append('\'').append('}').toString();
    }
}
