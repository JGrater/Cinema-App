package com.ada.cinema.model.cinema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Address {
    private String address_id;
    private String address;
    private String city;
    private String province;
    private String postcode;    
    private String country;
}
