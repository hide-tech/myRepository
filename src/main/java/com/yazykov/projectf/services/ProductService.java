package com.yazykov.projectf.services;

import com.yazykov.projectf.models.storage.Product;
import com.yazykov.projectf.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product getProductByName(String name){
        Product product = productRepository.findByProductName(name);
        return product;
    }

    public Product getProductById(Long id){
        return productRepository.getById(id);
    }

    public List<Product> getSortedProductListByQuantity(){
        return productRepository.findAll().stream()
                .sorted((p1,p2)-> Math.toIntExact(p1.getQuantity() - p2.getQuantity()))
                .collect(Collectors.toList());
    }
}
