package com.ada.cinema.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PaymentRequest {
    private String payment_id;
    private String user_id;
    private String card_name;
    private String card_number;
    private String expiry_date;
    private String cvv;
}
