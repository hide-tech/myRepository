package com.yazykov.projectf.models.storage;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bank_pay_info")
public class PayInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "acc_number")
    private String accountNumber;
    @Column(name = "bik")
    private String bikNumber;
    @OneToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
