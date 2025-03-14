package com.ada.cinema.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Login {
    private String login_id;
    private String user_id;
    private String username;
    private String password;
}
