package com.yazykov.projectf.repositories;

import com.yazykov.projectf.models.storage.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
