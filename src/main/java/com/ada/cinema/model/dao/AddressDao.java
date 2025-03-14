package com.ada.cinema.model.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(
        name = "address"
)
@Getter
@Setter
public class AddressDao {
 
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String province;

    @Column
    private String postcode;

    @Column
    private String country;

    public AddressDao(String address, String city, String province, String postcode, String country) {
        this.address = address;
        this.city = city;
        this.province = province;
        this.postcode = postcode;
        this.country = country;
    }

    public AddressDao() {

    }

}
