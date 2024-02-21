package com.ada.cinema.repository;

import com.ada.cinema.model.dao.PaymentDao;
import com.ada.cinema.model.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentDao, UUID> {

    PaymentDao findByUserDao(UserDao userDao);

}
