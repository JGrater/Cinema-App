package com.ada.cinema.repository;

import com.ada.cinema.model.dao.CinemaDao;
import com.ada.cinema.model.dao.ScreeningDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScreeningRepository extends JpaRepository<ScreeningDao, UUID> {
    List<ScreeningDao> findAllByMovie_id(int movie_id);

    List<ScreeningDao> findAllByCinemaDaoAndMovie_id(CinemaDao cinemaDao, int movie_id);


}
