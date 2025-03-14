package com.ada.cinema.model.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "screening"
)
@Getter
@Setter
public class ScreeningDao {

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
    private int movieId;

    @Column
    @Check(constraints = "price > 0")
    private double price;

    @Column
    private LocalDateTime screeningDate;

    public ScreeningDao(ScreenDao screenDao, int movieId, double price, LocalDateTime screeningDate) {
        this.screenDao = screenDao;
        this.movieId = movieId;
        this.price = price;
        this.screeningDate = screeningDate;
    }

    public ScreeningDao() {
    }

}
