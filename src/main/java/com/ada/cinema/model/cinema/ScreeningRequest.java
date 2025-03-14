package com.ada.cinema.model.cinema;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ScreeningRequest {
    private String screening_id;
    private int movie_id;
    private String screen_id;
    private Double price;
    private LocalDateTime date;
}
