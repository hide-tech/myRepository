package com.yazykov.projectf.services.impl;

import com.yazykov.projectf.dto.AddressDto;
import com.yazykov.projectf.dto.PayInfoDto;
import com.yazykov.projectf.dto.SupplierDto;
import com.yazykov.projectf.models.storage.Supplier;
import com.yazykov.projectf.repositories.SupplierRepository;
import com.yazykov.projectf.services.AddressService;
import com.yazykov.projectf.services.PayInfoService;
import com.yazykov.projectf.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private PayInfoService payInfoService;
    @Autowired
    private AddressService addressService;

    public List<SupplierDto> getAllSuppliers(){
        return convertSuppliersToDto(supplierRepository.findAll());
    }

    public SupplierDto getSupplierById(Long id){
        return convertSupplierToDto(supplierRepository.getById(id));
    }

    @Override
    public Supplier save(SupplierDto supplierDto) {
        Supplier supplier = new Supplier();

        supplier.setCompanyName(supplierDto.getNameDto());

        supplier.setAddress(addressService.save(supplierDto.getAddressDto()));
        supplier.setPayInfo(payInfoService.save(supplierDto.getPayInfoDto()));

        Supplier result = supplierRepository.save(supplier);
        return result;
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteAllById(Collections.singleton(id));
    }

//    private PayInfo extractPayInfo(SupplierDto supplierDto){
//        PayInfo payInfo = new PayInfo();
//        payInfo.setBankName(supplierDto.getPayInfoDto().getBankName());
//        payInfo.setAccountNumber(supplierDto.getPayInfoDto().getAccountNumber());
//        payInfo.setBikNumber(supplierDto.getPayInfoDto().getBikNumber());
//        return payInfo;
//    }
//
//    private Address extractedAddress(SupplierDto supplierDto) {
//        Address address = new Address();
//        address.setCountry(supplierDto.getAddressDto().getCountry());
//        address.setCity(supplierDto.getAddressDto().getCity());
//        address.setStreet(supplierDto.getAddressDto().getStreet());
//        address.setBuilding(supplierDto.getAddressDto().getBuilding());
//        address.setExtension(supplierDto.getAddressDto().getExtension());
//        address.setOffice(supplierDto.getAddressDto().getOffice());
//        return address;
//    }

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
