package com.yazykov.projectf.services.impl;

import com.yazykov.projectf.dto.AddressDto;
import com.yazykov.projectf.models.storage.Address;
import com.yazykov.projectf.repositories.AddressRepository;
import com.yazykov.projectf.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(AddressDto addressDto) {
        Address address = convertDtoToAddress(addressDto);
        return addressRepository.save(address);
    }

    private Address convertDtoToAddress(AddressDto addressDto) {
        Address address = new Address();

        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setBuilding(addressDto.getBuilding());
        address.setExtension(addressDto.getExtension());
        address.setOffice(addressDto.getOffice());

        return address;
    }

    @Override
    public void delete(Long id) {
        addressRepository.delete(addressRepository.getById(id));
    }
}
