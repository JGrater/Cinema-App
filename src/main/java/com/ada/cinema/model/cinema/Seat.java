package com.ada.cinema.model.cinema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Seat {
    private String seat_id;
    private String screen_id; 
    private char row;
    private int seat_number;
}
