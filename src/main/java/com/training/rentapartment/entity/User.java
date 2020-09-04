package com.training.rentapartment.entity;

import java.util.Objects;

public class User {
    private int userId;
    private String login;
    private String password;
    private UserType type;
    private String email;
    private boolean verified;

    public User() {
    }

    public User(String login, String password,UserType type, String email, boolean verified) {
        this.login = login;
        this.password = password;
        this.type = type;
        this.email = email;
        this.verified = verified;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
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

    public boolean getVerified(){ return  verified; }
    public void setVerified(boolean verified){ this.verified = verified; }

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
                Objects.equals(email, user.email) &&
                verified == user.verified;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, type, login, password, email, verified); //TODO
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User{" + "id=").append(userId).append(", type=")
                .append(type).append(", login='").append(login).append('\'')
                .append(", password='").append(password).append('\'')
                .append(", email='").append(email)
                .append(", verified= '").append(verified)
                .append('\'').append('}').toString();
    }
}
