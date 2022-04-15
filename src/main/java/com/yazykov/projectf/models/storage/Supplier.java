package com.yazykov.projectf.models.storage;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(companyName, supplier.companyName) && Objects.equals(address, supplier.address) && Objects.equals(payInfo, supplier.payInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, address, payInfo, products);
    }
}
