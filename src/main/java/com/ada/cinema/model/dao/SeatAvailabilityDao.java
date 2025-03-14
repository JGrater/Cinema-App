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
        name = "seat_availability"
)
@Getter
@Setter
public class SeatAvailabilityDao {
    
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
    
    @Column
    private boolean isAvailable;

    public SeatAvailabilityDao(ScreeningDao screeningDao, SeatDao seatDao, boolean isAvailable) {
        this.screeningDao = screeningDao;
        this.seatDao = seatDao;
        this.isAvailable = isAvailable;
    }

    public SeatAvailabilityDao() {
    }

}
