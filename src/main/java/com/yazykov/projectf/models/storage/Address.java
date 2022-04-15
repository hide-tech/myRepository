package com.yazykov.projectf.models.storage;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(building, address.building) && Objects.equals(extension, address.extension) && Objects.equals(office, address.office);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, building, extension, office);
    }
}
