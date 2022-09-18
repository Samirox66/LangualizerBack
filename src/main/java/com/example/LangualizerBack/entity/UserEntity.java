package com.example.LangualizerBack.entity;

import org.springframework.data.annotation.Id;

public class UserEntity {

    @Id
    private String id;

    private String email;

    private String password;
    private String username;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity() {}

    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, name='%s', email='%s'", id, username, email
        );
    }
}
