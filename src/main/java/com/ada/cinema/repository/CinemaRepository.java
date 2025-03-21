package com.ada.cinema.repository;

import com.ada.cinema.model.dao.CinemaDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CinemaRepository extends JpaRepository<CinemaDao, UUID> {
}
