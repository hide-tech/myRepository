package com.yazykov.projectf.services.impl;

import com.yazykov.projectf.dto.ProductDto;
import com.yazykov.projectf.dto.SupplierDto;
import com.yazykov.projectf.models.storage.Product;
import com.yazykov.projectf.repositories.ProductRepository;
import com.yazykov.projectf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getProductList(){
        List<Product> products = productRepository.findAll();
        return mapToDto(products);
    }

    public ProductDto getProductByName(String name){
        Product product = productRepository.findByProductName(name);
        return mapDtoProduct(product);
    }

    public ProductDto getProductById(Long id){
        return mapDtoProduct(productRepository.getById(id));
    }

    public List<ProductDto> getSortedProductListByQuantity(){
        return mapToDto(productRepository.findAll().stream()
                .sorted((p1,p2)-> Math.toIntExact(p1.getQuantity() - p2.getQuantity()))
                .collect(Collectors.toList()));
    }

    public List<ProductDto> mapToDto(List<Product> products){
        return products.stream().map(product -> {
            return mapDtoProduct(product);
        }).collect(Collectors.toList());
    }

    public ProductDto mapDtoProduct(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setId(product.getId());
        productDto.setPrice(productDto.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setSupplyDate(product.getSupplyDate().toString());

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameDto(product.getSupplier().getCompanyName());
        productDto.setSupplier(supplierDto);
        return productDto;
    }
}
