package com.yazykov.projectf.services;

import com.yazykov.projectf.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    public List<SupplierDto> getAllSuppliers();

    public SupplierDto getSupplierById(Long id);

}
