package com.yazykov.projectf.controllers;

import com.yazykov.projectf.dto.SupplierDto;
import com.yazykov.projectf.models.storage.Supplier;
import com.yazykov.projectf.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/all")
    public List<SupplierDto> showAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierDto showSupplierById(@PathVariable("id") Long id){
        return supplierService.getSupplierById(id);
    }

    @PostMapping
    public String createNewSupplier(@RequestBody SupplierDto supplierDto){
        Supplier supplier = supplierService.save(supplierDto);
        return String.format("Supplier %s has been created successfully with id = %d",
                supplier.getCompanyName(), supplier.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteSupplier( @PathVariable("id") Long id){
        supplierService.delete(id);
        return "redirect:/products/suppliers/all";
    }
}
