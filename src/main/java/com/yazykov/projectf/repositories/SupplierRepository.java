package com.yazykov.projectf.repositories;

import com.yazykov.projectf.models.storage.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(name = "Suppliers.findAllSuppliersWithInfo",
        value = "SELECT s FROM Supplier s LEFT JOIN FETCH s.address")
    List<Supplier> findAllSuppliersWithAddress();
}
