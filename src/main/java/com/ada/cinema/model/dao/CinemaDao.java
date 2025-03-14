package com.ada.cinema.model.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(
        name = "cinema"
)
@Getter
@Setter
public class CinemaDao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressDao addressDao;

    @Column
    private String name;

    @Column
    private String company_name;

    @Column
    private int screens;

    public CinemaDao(AddressDao addressDao, String name, String company_name, int screens) {
        this.addressDao = addressDao;
        this.name = name;
        this.company_name = company_name;
        this.screens = screens;
    }

    public CinemaDao() {
    }

}
