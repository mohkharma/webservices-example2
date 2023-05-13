package com.example.demo.dto;

/**
 * Author: Mohammed Kharma
 */
public class CustomerDto {
    private String firstname;
    private String lastname;

    public CustomerDto() {
    }

    public CustomerDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
