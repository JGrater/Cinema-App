package com.ada.cinema.model;

import lombok.Data;

@Data
public class User {

    private String accountId;

    private String username;
    private String password;

    private String name;
    private String postcode;

}
