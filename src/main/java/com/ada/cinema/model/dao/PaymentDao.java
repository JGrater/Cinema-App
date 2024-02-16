package com.ada.cinema.model.dao;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(
        name = "payment"
)
public class PaymentDao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column
    private String paymentType;

    @Column
    private String cardNumber;

    @Column
    private String cardName;

    @Column
    private Date expiryDate;

    @Column
    private String cvv;

    public PaymentDao(UUID id, String paymentType, String cardNumber, String cardName, Date expiryDate, String cvv) {
        this.id = id;
        this.paymentType = paymentType;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public PaymentDao() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
