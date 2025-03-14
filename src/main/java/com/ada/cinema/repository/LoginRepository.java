package com.ada.cinema.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.cinema.model.dao.LoginDao;


public interface LoginRepository extends JpaRepository<LoginDao, UUID> {
    LoginDao findByUsernameAndPassword(String username, String password);
    
}
