package com.ada.cinema.controller;

import com.ada.cinema.model.dao.UserDao;
import com.ada.cinema.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final CinemaService cinemaService;

    public UserController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/register")
    ResponseEntity<String> register(
        @RequestParam() String username,
        @RequestParam() String password,
        @RequestParam() String email,
        @RequestParam() String firstName,
        @RequestParam() String lastName,
        @RequestParam() String address,
        @RequestParam() String city,
        @RequestParam() String province,
        @RequestParam() String country,
        @RequestParam() String postcode

        )
    {
        UserDao newUser = new UserDao(username, password, email, firstName, lastName, address, city, province, country, postcode);

        cinemaService.register(newUser);

        return ResponseEntity.ok().body("Account Registered");
    }

    @GetMapping("/getUser")
    ResponseEntity<List<UserDao>> getUser(
        @RequestParam() String username,
        @RequestParam() String password
    )
    {
        return ResponseEntity.ok().body(cinemaService.getUser(username, password));
    }

    @GetMapping("/getUser")
    ResponseEntity<Optional<UserDao>> getUser(
            @RequestParam() String id
    )
    {
        return ResponseEntity.ok().body(cinemaService.getUserById(id));
    }

    @GetMapping("/login")
    ResponseEntity<Boolean> login(
            @RequestParam() String username,
            @RequestParam() String password
    )
    {
        return ResponseEntity.ok().body(cinemaService.getUser(username, password).isEmpty());
    }

}
