package com.ada.cinema.model.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(
        name = "seat"
)
@Getter
@Setter
public class SeatDao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screen_id", referencedColumnName = "id")
    private ScreenDao screenDao;

    @Column
    private char row;

    @Column
    private int seat_number;

    public SeatDao(ScreenDao screenDao, char row, int seat_number) {
        this.screenDao = screenDao;
        this.row = row;
        this.seat_number = seat_number;
        
    }

    public SeatDao() {
    }

}
