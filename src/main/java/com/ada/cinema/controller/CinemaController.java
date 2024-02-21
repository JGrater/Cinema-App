package com.ada.cinema.controller;

import com.ada.cinema.model.dao.*;
import com.ada.cinema.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/cinema")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    // make booking > create ticket >
    /*@GetMapping("/processBooking")
    public ResponseEntity<TicketDao> booking(@RequestParam() String screening_id) {
        return ResponseEntity.ok().body();
    }

     */

    // Add cinema
    @PostMapping("/add")
    public ResponseEntity<CinemaDao> addCinema(
            @RequestParam() String name,
            @RequestParam() String company_name,
            @RequestParam() String address,
            @RequestParam() String city,
            @RequestParam() String province,
            @RequestParam() String country,
            @RequestParam() String postcode,
            @RequestParam() int screens)
    {
        return ResponseEntity.ok().body(cinemaService.addCinema(new CinemaDao(name, company_name, address, city, province, country, postcode, LocalDateTime.now(),screens)));
    }

    // Add Screening
    @PostMapping("/screening/add")
    public ResponseEntity<ScreeningDao> addScreening(
            @RequestParam() double price,
            @RequestParam() LocalDateTime screening_date,
            @RequestParam() String cinema_id,
            @RequestParam() int movie_id)
    {
        return ResponseEntity.ok().body(cinemaService.addScreening(new ScreeningDao(price, screening_date, cinemaService.getCinemaById(cinema_id),movie_id)));
    }

    // Add seat
    @PostMapping("/seat/add")
    public ResponseEntity<SeatDao> addSeat(
            @RequestParam() int screen_number,
            @RequestParam() char row,
            @RequestParam() int seat_number,
            @RequestParam() String cinema_id)
    {
        return ResponseEntity.ok().body(cinemaService.addSeat(new SeatDao(screen_number, row, seat_number, cinemaService.getCinemaById(cinema_id))));
    }

    @PostMapping("/ticket/add")
    public ResponseEntity<TicketDao> addTicket(
            @RequestParam() String screening_id,
            @RequestParam() String seat_id,
            @RequestParam() String user_id)
    {
        return ResponseEntity.ok().body(cinemaService.addTicket(new TicketDao(LocalDateTime.now(),
                cinemaService.getScreeningById(screening_id),
                cinemaService.getSeatById(seat_id),
                cinemaService.getUserById(user_id))));
    }

    // Returns list of cinemas screening movie
    @GetMapping("/screening/list")
    public ResponseEntity<List<CinemaDao>> cinemasScreeningList(@RequestParam() int movie_id) {
        return ResponseEntity.ok().body(cinemaService.getCinemaListByMovie(movie_id));
    }

    // Returns screening details by id
    @GetMapping("/screening/details")
    public ResponseEntity<ScreeningDao> screeningDetails(@RequestParam() String screening_id) {
        return ResponseEntity.ok().body(cinemaService.getScreeningById(screening_id));
    }

    // Returns list of screenings by movie and cinema
    @GetMapping("/screening/details/list")
    public ResponseEntity<List<ScreeningDao>> screeningDetailsList(
        @RequestParam() String cinema_id,
        @RequestParam() int movie_id)
    {
        return ResponseEntity.ok().body(cinemaService.getScreeningsByCinemaAndMovie(cinema_id, movie_id));
    }

    // Returns list of available seats for screening
    /*@GetMapping("/screening/available")
    public ResponseEntity<List<SeatDao>> screeningAvailability(@RequestParam() String screening_id) {
        return ResponseEntity.ok().body(cinemaService.getSeatListAvailableByScreening(screening_id));
    }

     */

    // Return seat details by id
    @GetMapping("/seat/details")
    public ResponseEntity<SeatDao> seatDetails(@RequestParam() String seat_id) {
        return ResponseEntity.ok().body(cinemaService.getSeatById(seat_id));
    }

    // Returns true if seat is free for screening
    /*@GetMapping("/seat/available")
    public ResponseEntity<Boolean> seatAvailability(
            @RequestParam() String screening_id,
            @RequestParam() String seat_id)
    {
        return ResponseEntity.ok().body(cinemaService.)
    }

     */

    // Returns ticket details by id
    @GetMapping("/ticket/details")
    public ResponseEntity<TicketDao> ticketDetails(@RequestParam() String ticket_id) {
        return ResponseEntity.ok().body(cinemaService.getTicketById(ticket_id));
    }
}
