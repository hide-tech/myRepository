package com.yazykov.projectf.controllers;

import com.yazykov.projectf.dto.ProductDto;
import com.yazykov.projectf.models.storage.Product;
import com.yazykov.projectf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> showAllProducts(){
        return productService.getProductList();
    }

    @GetMapping("/sort")
    public List<ProductDto> showAllSortedProducts(){
        return productService.getSortedProductListByQuantity();
    }

    @GetMapping("/{id}")
    public ProductDto showProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/byname/{name}")
    public ProductDto showProductByName(@PathVariable("name") String name){
        return productService.getProductByName(name);
    }

    @PostMapping
    public String addProductAtStorage(@RequestBody ProductDto productDto){
        Product product = productService.save(productDto);
        return String.format("Product %s was successfully save with id = %d",
                product.getProductName(), product.getId());
    }

}
