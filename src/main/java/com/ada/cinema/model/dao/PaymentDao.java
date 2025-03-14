package com.ada.cinema.model.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(
        name = "payment"
)
@Getter
@Setter
public class PaymentDao {

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
    private String card_number;

    @Column
    private String card_name;

    @Column
    private LocalDate expiry_date;

    @Column
    private String cvv;

    public PaymentDao(UserDao userDao, String card_number, String card_name, LocalDate expiry_date, String cvv) {
        this.userDao = userDao;
        this.card_number = card_number;
        this.card_name = card_name;
        this.expiry_date = expiry_date;
        this.cvv = cvv;
    }

    public PaymentDao() {

    }
}
