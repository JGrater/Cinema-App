package com.ada.cinema.service;

import com.ada.cinema.model.dao.UserDao;
import com.ada.cinema.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CinemaService {

    private final UserRepository userRepository;

    public UserDao register(UserDao user) {
        return userRepository.save(user);
    }

    public List<UserDao> getUser(String username, String password) {
        return userRepository.findAllByUsernameAndPassword(username, password);
    }

    public Optional<UserDao> getUserById(String id) {
        UUID uuid = UUID.fromString(id);
        return userRepository.findById(uuid);
    }

}
