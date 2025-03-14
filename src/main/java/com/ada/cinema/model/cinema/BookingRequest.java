package com.ada.cinema.model.cinema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookingRequest {
    private String ticket_id;
    private String screening_id;
    private String seat_id;
    private String user_id;
}
