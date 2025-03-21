package com.ada.cinema.repository;

import com.ada.cinema.model.dao.ScreenDao;
import com.ada.cinema.model.dao.ScreeningDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScreeningRepository extends JpaRepository<ScreeningDao, UUID> {
    List<ScreeningDao> findAllByMovieId(int movieId);
    List<ScreeningDao> findAllByScreenDao(ScreenDao screenDao);
    List<ScreeningDao> findAllByScreenDaoAndMovieId(ScreenDao screenDao, int movieId);

}
