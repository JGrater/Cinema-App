package com.ada.cinema.controller;

import com.ada.cinema.model.cinema.Address;
import com.ada.cinema.model.cinema.BookingRequest;
import com.ada.cinema.model.cinema.CinemaRequest;
import com.ada.cinema.model.cinema.ScreeningRequest;
import com.ada.cinema.model.dao.*;
import com.ada.cinema.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@Slf4j
@RequestMapping("/cinema")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("")
    public ResponseEntity<CinemaDao> cinemaDetails(@RequestParam() String cinema_id) {
        return ResponseEntity.ok().body(cinemaService.getCinemaById(cinema_id));
    }

    // Add cinema
    @PostMapping("/add")
    public ResponseEntity<CinemaDao> addCinema(@RequestBody CinemaRequest cinemaRequest) {
        Address address = cinemaRequest.getAddress();
        AddressDao addressDao = cinemaService.addAddress(new AddressDao(
            address.getAddress(), 
            address.getCity(), 
            address.getProvince(), 
            address.getPostcode(), 
            address.getCountry()
        ));
        CinemaDao cinema = cinemaService.addCinema(new CinemaDao(
            addressDao, 
            cinemaRequest.getName(), 
            cinemaRequest.getCompany_name(), 
            cinemaRequest.getScreens().size()
        ));
        
        cinemaRequest.getScreens().forEach(screen -> {
            ScreenDao screenDao = cinemaService.addScreen(new ScreenDao(cinema, screen.getScreen_number()));
            screen.getSeats().forEach(seat -> {
                cinemaService.addSeat(new SeatDao(screenDao, seat.getRow(), seat.getSeat_number()));
            });
        });
        return ResponseEntity.ok().body(cinema);
    }

    // Add Screening
    @PostMapping("/screening/add")
    public ResponseEntity<ScreeningDao> addScreening(@RequestBody ScreeningRequest screeningRequest) {

        ScreeningDao screeningDao = new ScreeningDao(
            cinemaService.getScreenById(screeningRequest.getScreen_id()),
            screeningRequest.getMovie_id(),
            screeningRequest.getPrice(),
            screeningRequest.getDate()
        );

        List<SeatDao> seats = cinemaService.getAllSeatsByScreenId(screeningRequest.getScreen_id());
        seats.forEach(seat -> {
            cinemaService.addSeatAvailability(new SeatAvailabilityDao(screeningDao, seat, true));
        });

        return ResponseEntity.ok().body(screeningDao);
    }

    // Returns list of cinemas screening movie
    @GetMapping("/movie")
    public ResponseEntity<List<CinemaDao>> cinemasScreeningList(@RequestParam() int movie_id) {
        List<ScreeningDao> screenings = cinemaService.getScreeningsByMovieId(movie_id);
        List<CinemaDao> cinemas = screenings.stream()
            .map(screening -> screening.getScreenDao().getCinemaDao())
            .toList();
        return ResponseEntity.ok().body(cinemas);
    }

    // Returns screening details by id
    @GetMapping("/screening")
    public ResponseEntity<ScreeningDao> screeningDetails(@RequestParam() String screening_id) {
        return ResponseEntity.ok().body(cinemaService.getScreeningById(screening_id));
    }

    @GetMapping("/screenings")
    public ResponseEntity<List<ScreeningDao>> screeningList(@RequestParam String cinema_id) {
        List<ScreenDao> screens = cinemaService.getScreensByCinemaID(cinema_id);
        List<ScreeningDao> screenings = screens.stream()
            .map(screen -> cinemaService.getScreeningsByScreen(screen))
            .flatMap(List::stream)
            .filter(screening -> screening.getScreeningDate().isAfter(LocalDateTime.now()))
            .toList();
        return ResponseEntity.ok().body(screenings);
    }
    

    // Returns list of screenings by movie and cinema
    @GetMapping("/screenings/movie")
    public ResponseEntity<List<ScreeningDao>> screeningsMovieList(
            @RequestParam() String cinema_id,
            @RequestParam() int movie_id
    ) {
        List<ScreenDao> screens = cinemaService.getScreensByCinemaID(cinema_id);
        List<ScreeningDao> screenings = screens.stream()
            .map(screen -> cinemaService.getScreeningsByScreenAndMovieId(screen, movie_id))
            .flatMap(List::stream)
            .filter(screening -> screening.getScreeningDate().isAfter(LocalDateTime.now()))
            .toList();
        return ResponseEntity.ok().body(screenings);
    }

    // Returns list of available seats for screening
    @GetMapping("/screening/available")
    public ResponseEntity<List<SeatDao>> screeningAvailability(@RequestParam() String screening_id) {
        return ResponseEntity.ok().body(cinemaService.getSeatsAvailableByScreening(screening_id));
    }

    @GetMapping("/screen/seats")
    public ResponseEntity<List<SeatDao>> screeningSeats(@RequestParam() String screen_id) {
        return ResponseEntity.ok().body(cinemaService.getAllSeatsByScreenId(screen_id));
    }

    // Returns ticket details by id
    @GetMapping("/ticket")
    public ResponseEntity<TicketDao> ticketDetails(@RequestParam() String ticket_id) {
        return ResponseEntity.ok().body(cinemaService.getTicketById(ticket_id));
    }

    @PostMapping("/ticket/booking")
    public ResponseEntity<TicketDao> booking(@RequestBody BookingRequest bookingRequest) {

        cinemaService.updateSeatAvailability(bookingRequest.getScreening_id(), bookingRequest.getSeat_id(), false);
        
        return ResponseEntity.ok().body(cinemaService.addTicket(new TicketDao(
            cinemaService.getScreeningById(bookingRequest.getScreening_id()),
            cinemaService.getSeatById(bookingRequest.getSeat_id()),
            cinemaService.getUserById(bookingRequest.getUser_id()),
            LocalDateTime.now()
        )));
    }
}
