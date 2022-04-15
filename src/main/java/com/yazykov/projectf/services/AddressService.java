package com.yazykov.projectf.services;

import com.yazykov.projectf.dto.AddressDto;
import com.yazykov.projectf.models.storage.Address;

public interface AddressService {

    Address save(AddressDto addressDto);

    void delete(Long id);

}
