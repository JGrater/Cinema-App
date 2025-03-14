package com.ada.cinema.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ada.cinema.model.dao.AddressDao;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressDao, UUID> {
    
}
