package com.ada.cinema.controller;

import com.ada.cinema.model.dao.PaymentDao;
import com.ada.cinema.model.dao.ScreeningDao;
import com.ada.cinema.model.dao.TicketDao;
import com.ada.cinema.model.dao.UserDao;
import com.ada.cinema.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
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


    @PostMapping("/register")
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

        cinemaService.registerUser(newUser);

        return ResponseEntity.ok().body("Account Registered");
    }

    // Return true if username is valid


    // Returns user profile by username and password
    @GetMapping("/details")
    ResponseEntity<UserDao> userDetails(
        @RequestParam() String username,
        @RequestParam() String password
    )
    {
        return ResponseEntity.ok().body(cinemaService.getUser(username, password));
    }

    // Returns user profile by id
    @GetMapping("/detailsById")
    ResponseEntity<UserDao> userDetails(
            @RequestParam() String id
    )
    {
        return ResponseEntity.ok().body(cinemaService.getUserById(id));
    }

    // Returns false if user doesn't exist
    @GetMapping("/login")
    ResponseEntity<Boolean> login(
            @RequestParam() String username,
            @RequestParam() String password
    )
    {
        return ResponseEntity.ok().body(!cinemaService.getUser(username,password).getClass().equals(UserDao.class));
    }

    // Add payment
    @PostMapping("/payment/add")
    public ResponseEntity<PaymentDao> addScreening(
            @RequestParam() String payment_type,
            @RequestParam() String card_number,
            @RequestParam() String card_name,
            @RequestParam() Date expiry_date,
            @RequestParam() String cvv,
            @RequestParam() String user_id)
    {
        return ResponseEntity.ok().body(cinemaService.addPaymentDetails(new PaymentDao(payment_type, card_number, card_name, expiry_date, cvv, cinemaService.getUserById(user_id))));
    }

    // Returns users payment details
    @GetMapping("/payment/details")
    public ResponseEntity<PaymentDao> paymentDetails(@RequestParam() String user_id) {
        return ResponseEntity.ok().body(cinemaService.getPaymentDetailsByUserId(user_id));
    }

    // Returns list of users tickets
    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDao>> userTickets(@RequestParam() String user_id) {
        return ResponseEntity.ok().body(cinemaService.getUserTickets(user_id));
    }

}
