package com.ada.cinema.service;

import com.ada.cinema.model.dao.*;
import com.ada.cinema.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class CinemaService {

    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;
    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;
    private final ScreeningRepository screeningRepository;
    private final CinemaRepository cinemaRepository;

    public UserDao registerUser(UserDao user) {
        return userRepository.save(user);
    }

    public UserDao getUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public UserDao getUserById(String user_id) {
        return userRepository.getById(UUID.fromString(user_id));
    }

    public PaymentDao getPaymentDetailsByUserId(String user_id) {
        return paymentRepository.findByUserDao(getUserById(user_id));
    }

    public SeatDao getSeatById(String seat_id) {
        return seatRepository.getById(UUID.fromString(seat_id));
    }

    public TicketDao getTicketById(String ticket_id) {
        return ticketRepository.getById(UUID.fromString(ticket_id));
    }

    public List<TicketDao> getUserTickets(String user_id) {
        return ticketRepository.findAllByUserDao(getUserById(user_id));
    }

    public ScreeningDao getScreeningById(String screening_id) {
        return screeningRepository.getById(UUID.fromString(screening_id));
    }

    public CinemaDao getCinemaById(String cinema_id) {
        return cinemaRepository.getById(UUID.fromString(cinema_id));
    }

    public List<CinemaDao> getCinemaListByMovie(int movie_id) {
        List<ScreeningDao> screeningList = screeningRepository.findAllByMovieId(movie_id);
        List<CinemaDao> cinemaList = new ArrayList<>();
        for (ScreeningDao screeningDao : screeningList) {
            cinemaList.add(cinemaRepository.getById(screeningDao.getCinemaDao().getId()));
        }
        return cinemaList.stream()
            .collect(Collectors.toMap(v -> v.getId(),
                v -> v,
                (a, b) -> a
            )).values().stream().toList();
    }

    public List<ScreeningDao> getScreeningsByCinemaAndMovie(String cinema_id, int movie_id) {
        return screeningRepository.findAllByCinemaDaoAndMovieId(getCinemaById(cinema_id), movie_id);
    }

    /*public List<SeatDao> getSeatListAvailableByScreening(String screening_id) {
        List<TicketDao> ticketList = ticketRepository.findAllByScreeningDao(getScreeningById(screening_id));
        List<SeatDao> seatList = seatRepository.findAllAvailableSeats(
                    ticketList.get(i),
                    ticketList.get(i).getSeatDao().getCinemaDao(),
                    ticketList.get(i).getSeatDao().getScreen_number()
            ));
        }
    }

     */

    public CinemaDao addCinema(CinemaDao cinemaDao) {
        return cinemaRepository.save(cinemaDao);
    }

    public ScreeningDao addScreening(ScreeningDao screeningDao) {
        return screeningRepository.save(screeningDao);
    }

    public SeatDao addSeat(SeatDao seatDao) {
        return seatRepository.save(seatDao);
    }

    public TicketDao addTicket(TicketDao ticketDao) {
        return ticketRepository.save(ticketDao);
    }

    public PaymentDao addPaymentDetails(PaymentDao paymentDao) {
        return paymentRepository.save(paymentDao);
    }


}
