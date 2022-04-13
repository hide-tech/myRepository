package com.yazykov.projectf.services;

import com.yazykov.projectf.dto.ProductDto;
import com.yazykov.projectf.models.storage.Product;

import java.util.List;

public interface ProductService {

    public List<ProductDto> getProductList();

    public ProductDto getProductByName(String name);

    public ProductDto getProductById(Long id);

    public List<ProductDto> getSortedProductListByQuantity();
}
