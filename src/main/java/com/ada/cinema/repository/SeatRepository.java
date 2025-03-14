package com.ada.cinema.repository;

import com.ada.cinema.model.dao.ScreenDao;
import com.ada.cinema.model.dao.SeatDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<SeatDao, UUID> {

    List<SeatDao> findAllByScreenDao(ScreenDao screenDao);
}
