package com.Dostava.dto;

import lombok.Data;

@Data

public class CreateUserDto {

    private String firstName;

    private String lastName;

    private String gender;

    private String address;

    private String username;

    private String password;

    private double paycheck;

}
