package com.yazykov.projectf.controllers;

import com.yazykov.projectf.dto.SupplierDto;
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
    public @ResponseBody List<SupplierDto> showAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public @ResponseBody SupplierDto showSupplierById(@PathVariable("id") Long id){
        return supplierService.getSupplierById(id);
    }
}
