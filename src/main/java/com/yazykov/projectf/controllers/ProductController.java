package com.yazykov.projectf.controllers;

import com.yazykov.projectf.dto.ProductDto;
import com.yazykov.projectf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> showAllProducts(){
        return productService.mapToDto(productService.getProductList());
    }

    @GetMapping("/sort")
    public List<ProductDto> showAllSortedProducts(){
        return productService.mapToDto(productService.getSortedProductListByQuantity());
    }

    @GetMapping("/{id}")
    public ProductDto showProductById(@PathVariable("id") Long id){
        return productService.mapDtoProduct(productService.getProductById(id));
    }

    @GetMapping("/byname/{name}")
    public ProductDto showProductByName(@PathVariable("name") String name){
        return productService.mapDtoProduct(productService.getProductByName(name));
    }

}
