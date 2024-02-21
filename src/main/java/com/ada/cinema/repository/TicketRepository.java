package com.ada.cinema.repository;

import com.ada.cinema.model.dao.ScreeningDao;
import com.ada.cinema.model.dao.TicketDao;
import com.ada.cinema.model.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketDao, UUID> {

    List<TicketDao> findAllByUserDao(UserDao userDao);

    List<TicketDao> findAllByScreeningDao(ScreeningDao screeningDao);

}
