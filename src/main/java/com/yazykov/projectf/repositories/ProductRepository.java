package com.yazykov.projectf.repositories;

import com.yazykov.projectf.models.storage.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductName(String productName);

//    @Query(name = "Products.findAllWithSuppliers",
//        value = "SELECT p FROM Product p LEFT JOIN FETCH p.suppliers")
//    List<Product> findAllProducts();
}
