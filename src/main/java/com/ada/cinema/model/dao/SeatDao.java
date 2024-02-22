package com.ada.cinema.model.dao;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(
        name = "seat"
)
public class SeatDao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column
    private int screenNumber;

    @Column
    private char row;

    @Column
    private int seat_number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    private CinemaDao cinemaDao;

    public SeatDao(int screenNumber, char row, int seat_number, CinemaDao cinemaDao) {
        this.screenNumber = screenNumber;
        this.row = row;
        this.seat_number = seat_number;
        this.cinemaDao = cinemaDao;
    }

    public SeatDao() {
    }

    public UUID getId() {
        return id;
    }

    public int getScreen_number() {
        return screenNumber;
    }

    public void setScreen_number(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public CinemaDao getCinemaDao() {
        return cinemaDao;
    }

    public void setCinemaDao(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }
}
