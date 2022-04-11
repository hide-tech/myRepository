package com.yazykov.projectf.dto;

import com.yazykov.projectf.models.storage.Address;
import com.yazykov.projectf.models.storage.Supplier;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String productName;
    private SupplierDto supplier;
    private String supplyDate;
    private Double price;
    private Long quantity;
}
