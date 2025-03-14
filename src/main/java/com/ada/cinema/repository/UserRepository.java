package com.ada.cinema.repository;

import com.ada.cinema.model.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDao, UUID> {

}
