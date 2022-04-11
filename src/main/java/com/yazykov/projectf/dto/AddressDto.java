package com.yazykov.projectf.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String country;
    private String city;
    private String street;
    private String building;
    private String extension;
    private String office;
}
