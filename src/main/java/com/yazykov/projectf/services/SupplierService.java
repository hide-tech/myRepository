package com.yazykov.projectf.services;

import com.yazykov.projectf.dto.AddressDto;
import com.yazykov.projectf.dto.PayInfoDto;
import com.yazykov.projectf.dto.SupplierDto;
import com.yazykov.projectf.models.storage.Supplier;
import com.yazykov.projectf.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id){
        return supplierRepository.getById(id);
    }

    public List<SupplierDto> convertSuppliersToDto(List<Supplier> suppliers){
        return suppliers.stream().map(supplier ->{
            return convertSupplierToDto(supplier);
        }).collect(Collectors.toList());
    }

    public SupplierDto convertSupplierToDto(Supplier supplier){
        if (supplier==null){
            return null;
        }

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameDto(supplier.getCompanyName());

        AddressDto addressDto = new AddressDto();
        addressDto.setCountry(supplier.getAddress().getCountry());
        addressDto.setCity(supplier.getAddress().getCity());
        addressDto.setStreet(supplier.getAddress().getStreet());
        addressDto.setBuilding(supplier.getAddress().getBuilding());
        addressDto.setExtension(supplier.getAddress().getExtension());
        addressDto.setOffice(supplier.getAddress().getOffice());
        supplierDto.setAddressDto(addressDto);

        PayInfoDto payInfoDto = new PayInfoDto();
        payInfoDto.setBankName(supplier.getPayInfo().getBankName());
        payInfoDto.setAccountNumber(supplier.getPayInfo().getAccountNumber());
        payInfoDto.setBikNumber(supplier.getPayInfo().getBikNumber());
        supplierDto.setPayInfoDto(payInfoDto);
        return supplierDto;
    }
}
