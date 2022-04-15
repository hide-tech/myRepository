package com.yazykov.projectf.models.storage;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayInfo payInfo = (PayInfo) o;
        return Objects.equals(bankName, payInfo.bankName) && Objects.equals(accountNumber, payInfo.accountNumber) && Objects.equals(bikNumber, payInfo.bikNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, accountNumber, bikNumber);
    }
}
