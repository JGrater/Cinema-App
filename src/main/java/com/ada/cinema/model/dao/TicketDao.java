package com.ada.cinema.model.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "ticket"
)
@Getter
@Setter
public class TicketDao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screening_id", referencedColumnName = "id")
    private ScreeningDao screeningDao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private SeatDao seatDao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDao userDao;

    @Column
    private LocalDateTime booking_date;

    public TicketDao(ScreeningDao screeningDao, SeatDao seatDao, UserDao userDao, LocalDateTime booking_date) {
        this.screeningDao = screeningDao;
        this.seatDao = seatDao;
        this.userDao = userDao;
        this.booking_date = booking_date;
    }

    public TicketDao() {
    }

}
