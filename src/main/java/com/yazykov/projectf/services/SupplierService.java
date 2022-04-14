package com.yazykov.projectf.services;

import com.yazykov.projectf.dto.SupplierDto;
import com.yazykov.projectf.models.storage.Supplier;

import java.util.List;

public interface SupplierService {

    public List<SupplierDto> getAllSuppliers();

    public SupplierDto getSupplierById(Long id);

    Supplier save(SupplierDto supplierDto);

    void delete(Long id);
}
