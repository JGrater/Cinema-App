package com.ada.cinema.repository;

import com.ada.cinema.model.dao.CinemaDao;
import com.ada.cinema.model.dao.SeatDao;
import com.ada.cinema.model.dao.TicketDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<SeatDao, UUID> {

    @Query("SELECT s FROM SeatDao s " +
            "WHERE s.cinemaDao = :cinemaDao " +
            "AND s.screen_number = :screen " +
            "AND s NOT IN (SELECT t.seatDao FROM TicketDao t WHERE t = :ticket)")
    List<SeatDao> findAllAvailableSeats(@Param("ticket") TicketDao ticketDao,
                                        @Param("cinema") CinemaDao cinemaDao,
                                        @Param("screen") int screen_number);
}
