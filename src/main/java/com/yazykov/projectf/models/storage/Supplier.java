package com.yazykov.projectf.models.storage;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String companyName;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address")
    private Address address;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pay_info")
    private PayInfo payInfo;
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
}
