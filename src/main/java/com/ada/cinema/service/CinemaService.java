package com.ada.cinema.service;

import com.ada.cinema.model.dao.*;
import com.ada.cinema.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CinemaService {

    private final UserRepository userRepository;
    private final LoginRepository loginRepository;
    private final PaymentRepository paymentRepository;
    private final SeatRepository seatRepository;
    private final SeatAvailabilityRepository seatAvailabilityRepository;
    private final TicketRepository ticketRepository;
    private final ScreeningRepository screeningRepository;
    private final CinemaRepository cinemaRepository;
    private final AddressRepository addressRepository;
    private final ScreenRepository screenRepository;

    public UserDao addUser(UserDao user) {
        return userRepository.save(user);
    }

    public LoginDao addLogin(LoginDao login) {
        return loginRepository.save(login);
    }

    public UserDao getUser(String username, String password) {
        LoginDao login = loginRepository.findByUsernameAndPassword(username, password);
        if (login == null) {
            return null;
        }
        return login.getUserDao();
    }

    public UserDao getUserById(String user_id) {
        return userRepository.findById(UUID.fromString(user_id)).get();
    }

    public PaymentDao getPaymentDetailsByUserId(String user_id) {
        return paymentRepository.findByUserDao(getUserById(user_id));
    }

    public SeatDao getSeatById(String seat_id) {
        return seatRepository.findById(UUID.fromString(seat_id)).get();
    }

    public TicketDao getTicketById(String ticket_id) {
        return ticketRepository.findById(UUID.fromString(ticket_id)).get();
    }

    public List<TicketDao> getUserTickets(String user_id) {
        return ticketRepository.findAllByUserDao(getUserById(user_id));
    }

    public ScreenDao getScreenById(String screen_id) {
        return screenRepository.findById(UUID.fromString(screen_id)).get();
    }

    public ScreeningDao getScreeningById(String screening_id) {
        return screeningRepository.findById(UUID.fromString(screening_id)).get();
    }

    public CinemaDao getCinemaById(String cinema_id) {
        return cinemaRepository.findById(UUID.fromString(cinema_id)).get();
    }

    public List<ScreeningDao> getScreeningsByMovieId(int movie_id) {
        return screeningRepository.findAllByMovieId(movie_id);
    }

    public List<ScreenDao> getScreensByCinemaID(String cinema_id) {
        return screenRepository.findAllByCinemaDao(getCinemaById(cinema_id));
    }

    public List<ScreeningDao> getScreeningsByScreen(ScreenDao screen) {
        return screeningRepository.findAllByScreenDao(screen);
    }

    public List<ScreeningDao> getScreeningsByScreenAndMovieId(ScreenDao screenDao, int movie_id) {
        return screeningRepository.findAllByScreenDaoAndMovieId(screenDao, movie_id);
    }

    public List<SeatDao> getAllSeatsByScreenId(String screen_id) {
        return seatRepository.findAllByScreenDao(getScreenById(screen_id));
    }

    public List<SeatDao> getAllSeatsByScreen(ScreenDao screen) {
        return seatRepository.findAllByScreenDao(screen);
    }

    public List<SeatDao> getSeatsAvailableByScreening(String screening_id) {
        List<SeatAvailabilityDao> availableSeats = seatAvailabilityRepository.findAllByScreeningDaoAndIsAvailable(getScreeningById(screening_id), true);
        return availableSeats.stream().map(SeatAvailabilityDao::getSeatDao).collect(Collectors.toList());
    }

    public CinemaDao addCinema(CinemaDao cinemaDao) {
        return cinemaRepository.save(cinemaDao);
    }

    public AddressDao addAddress(AddressDao addressDao) {
        return addressRepository.save(addressDao);
    }

    public ScreenDao addScreen(ScreenDao screenDao) {
        return screenRepository.save(screenDao);
    }

    public ScreeningDao addScreening(ScreeningDao screeningDao) {
        return screeningRepository.save(screeningDao);
    }

    public SeatDao addSeat(SeatDao seatDao) {
        return seatRepository.save(seatDao);
    }

    public SeatAvailabilityDao addSeatAvailability(SeatAvailabilityDao seatAvailabilityDao) {
        return seatAvailabilityRepository.save(seatAvailabilityDao);
    }

    public TicketDao addTicket(TicketDao ticketDao) {
        return ticketRepository.save(ticketDao);
    }

    public PaymentDao addPaymentDetails(PaymentDao paymentDao) {
        return paymentRepository.save(paymentDao);
    }

    public void updateSeatAvailability(String screening_id, String seat_id, boolean isAvailable) {
        SeatAvailabilityDao seatAvailabilityDao = seatAvailabilityRepository.findByScreeningDaoAndSeatDao(getScreeningById(screening_id), getSeatById(seat_id));
        seatAvailabilityDao.setAvailable(isAvailable);
        seatAvailabilityRepository.save(seatAvailabilityDao);
    }

}
