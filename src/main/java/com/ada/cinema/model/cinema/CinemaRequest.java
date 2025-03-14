package com.ada.cinema.model.cinema;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CinemaRequest {
    private String cinema_id;
    private String name;
    private String company_name;
    private Address address;
    private List<Screen> screens;
    

}
