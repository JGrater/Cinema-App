package com.ada.cinema.repository;

import com.ada.cinema.model.dao.CinemaDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CinemaRepository extends JpaRepository<CinemaDao, UUID> {

    List<CinemaDao> findDistinctById(UUID cinema_id);

}
