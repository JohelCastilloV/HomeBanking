package com.intelligo.banking.model;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String postalcode;
    private GeoLocation geoLocation;
}
