package com.ada.cinema.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.cinema.model.dao.ScreeningDao;
import com.ada.cinema.model.dao.SeatAvailabilityDao;
import com.ada.cinema.model.dao.SeatDao;

public interface SeatAvailabilityRepository extends JpaRepository<SeatAvailabilityDao, UUID>{
    public SeatAvailabilityDao findByScreeningDaoAndSeatDao(ScreeningDao screeningDao, SeatDao seatDao);
    public List<SeatAvailabilityDao> findAllByScreeningDaoAndIsAvailable(ScreeningDao screeningDao, boolean isAvailable);
}
