package com.ada.cinema.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.cinema.model.dao.CinemaDao;
import com.ada.cinema.model.dao.ScreenDao;

public interface ScreenRepository extends JpaRepository<ScreenDao, UUID> {
    public List<ScreenDao> findAllByCinemaDao(CinemaDao cinemaDao);
}
