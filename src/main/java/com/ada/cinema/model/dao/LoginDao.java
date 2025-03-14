package com.ada.cinema.model.dao;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "login",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
    }
)
@Getter
@Setter
public class LoginDao {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDao userDao;

    @Column
    private String username;

    @Column
    private String password;

    public LoginDao(UserDao userDao, String username, String password) {
        this.userDao = userDao;
        this.username = username;
        this.password = password;
    }

    public LoginDao() {
    }
}
