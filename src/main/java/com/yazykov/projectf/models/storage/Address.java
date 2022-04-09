package com.yazykov.projectf.models.storage;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address_tab")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "building")
    private String building;
    @Column(name = "extension")
    private String extension;
    @Column(name = "office")
    private String office;
}
