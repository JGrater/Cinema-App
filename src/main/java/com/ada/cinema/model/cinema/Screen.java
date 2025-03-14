package com.ada.cinema.model.cinema;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Screen {
    private String screen_id;
    private String cinema_id;
    private int screen_number;
    private List<Seat> seats; 
}
