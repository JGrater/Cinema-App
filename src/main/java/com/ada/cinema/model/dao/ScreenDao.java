package com.ada.cinema.model.dao;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "screen"
)
@Getter
@Setter
public class ScreenDao {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    private CinemaDao cinemaDao;

    @Column
    private int screen_number;

    public ScreenDao(CinemaDao cinemaDao, int screen_number) {
        this.cinemaDao = cinemaDao;
        this.screen_number = screen_number;
    }

    public ScreenDao() {
    }
}
