package com.ada.cinema.model.user;

import com.ada.cinema.model.cinema.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegisterRequest {
    private String user_id;
    private String email;
    private String name;
    private Login login;
    private Address address;
}
