package com.ada.cinema.controller;

import com.ada.cinema.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    private final CinemaService cinemaService;

    public PaymentController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }



}
