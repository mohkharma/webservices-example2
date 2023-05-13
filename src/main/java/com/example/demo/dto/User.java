package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Author: Mohammed Kharma
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"id"})
//@JsonIgnoreProperties is used at class level to mark a property or list of properties to be ignored.
public class User {
    private int id;
    private String name;

    //    @JsonIgnore  //@JsonIgnore is used at field level to mark a property or list of properties to be ignored.
    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
