package com.ada.cinema.controller;

import com.ada.cinema.model.dao.AddressDao;
import com.ada.cinema.model.dao.LoginDao;
import com.ada.cinema.model.dao.PaymentDao;
import com.ada.cinema.model.dao.TicketDao;
import com.ada.cinema.model.dao.UserDao;
import com.ada.cinema.model.user.PaymentRequest;
import com.ada.cinema.model.user.RegisterRequest;
import com.ada.cinema.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final CinemaService cinemaService;

    public UserController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }


    @PostMapping("/register")
    ResponseEntity<UserDao> register(@RequestBody RegisterRequest registerRequest) {
        AddressDao addressDao = cinemaService.addAddress(new AddressDao(
            registerRequest.getAddress().getAddress(), 
            registerRequest.getAddress().getCity(), 
            registerRequest.getAddress().getProvince(), 
            registerRequest.getAddress().getPostcode(),
            registerRequest.getAddress().getCountry()
        ));
        UserDao user = cinemaService.addUser(new UserDao(addressDao, registerRequest.getEmail(), registerRequest.getName()));
        cinemaService.addLogin(new LoginDao(user, registerRequest.getLogin().getUsername(), registerRequest.getLogin().getPassword()));
        return ResponseEntity.ok().body(user);
    }

    // Returns user profile by username and password
    @GetMapping("/login")
    ResponseEntity<UserDao> userDetails(
            @RequestParam() String username,
            @RequestParam() String password
    ) {
        return ResponseEntity.ok().body(cinemaService.getUser(username, password));
    }

    // Returns user profile by id
    @GetMapping("")
    ResponseEntity<UserDao> userDetails(
            @RequestParam() String user_id
    ) {
        return ResponseEntity.ok().body(cinemaService.getUserById(user_id));
    }

    // Add payment
    @PostMapping("/payment/add")
    public ResponseEntity<PaymentDao> addScreening(@RequestBody PaymentRequest paymentRequest) {
        UserDao user = cinemaService.getUserById(paymentRequest.getUser_id());
        return ResponseEntity.ok().body(cinemaService.addPaymentDetails(new PaymentDao(
            user, 
            paymentRequest.getCard_name(), 
            paymentRequest.getCard_number(), 
            LocalDate.parse(paymentRequest.getExpiry_date()), 
            paymentRequest.getCvv()
    )));
    }

    // Returns users payment details
    @GetMapping("/payment")
    public ResponseEntity<PaymentDao> paymentDetails(@RequestParam() String user_id) {
        return ResponseEntity.ok().body(cinemaService.getPaymentDetailsByUserId(user_id));
    }

    // Returns list of users tickets
    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDao>> userTickets(@RequestParam() String user_id) {
        return ResponseEntity.ok().body(cinemaService.getUserTickets(user_id));
    }

}
