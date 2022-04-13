package com.yazykov.projectf.models.storage;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String productName;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "supply_date")
    private LocalDate supplyDate;
    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;
}
