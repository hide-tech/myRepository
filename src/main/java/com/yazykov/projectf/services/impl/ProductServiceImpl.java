package com.yazykov.projectf.services.impl;

import com.yazykov.projectf.dto.AddressDto;
import com.yazykov.projectf.dto.PayInfoDto;
import com.yazykov.projectf.dto.ProductDto;
import com.yazykov.projectf.dto.SupplierDto;
import com.yazykov.projectf.models.storage.Product;
import com.yazykov.projectf.models.storage.Supplier;
import com.yazykov.projectf.repositories.ProductRepository;
import com.yazykov.projectf.services.ProductService;
import com.yazykov.projectf.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SupplierService supplierService;

    @Transactional
    public List<ProductDto> getProductList(){
        List<Product> products = productRepository.findAll();
        return mapToDto(products);
    }

    @Transactional
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

    @Override
    public Product save(ProductDto productDto) {
        Supplier supplier = supplierService.save(productDto.getSupplier());
        Product product = mapProductFromDto(productDto);

        product.setSupplier(supplier);
        return productRepository.save(product);
    }

    private Product mapProductFromDto(ProductDto productDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setSupplyDate(LocalDate.parse(productDto.getSupplyDate(),formatter));
        return product;
    }

    public List<ProductDto> mapToDto(List<Product> products){
        return products.stream().map(product -> {
            return mapDtoProduct(product);
        }).collect(Collectors.toList());
    }
//would be made through factory
    public ProductDto mapDtoProduct(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setId(product.getId());
        productDto.setPrice(productDto.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setSupplyDate(product.getSupplyDate().toString());

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setNameDto(product.getSupplier().getCompanyName());

        AddressDto addressDto = new AddressDto();
        addressDto.setCountry(product.getSupplier().getAddress().getCountry());
        addressDto.setCity(product.getSupplier().getAddress().getCity());
        addressDto.setStreet(product.getSupplier().getAddress().getStreet());
        addressDto.setBuilding(product.getSupplier().getAddress().getBuilding());
        addressDto.setExtension(product.getSupplier().getAddress().getExtension());
        addressDto.setOffice(product.getSupplier().getAddress().getOffice());
        supplierDto.setAddressDto(addressDto);

        PayInfoDto payInfoDto = new PayInfoDto();
        payInfoDto.setBankName(product.getSupplier().getPayInfo().getBankName());
        payInfoDto.setAccountNumber(product.getSupplier().getPayInfo().getAccountNumber());
        payInfoDto.setBikNumber(product.getSupplier().getPayInfo().getBikNumber());
        supplierDto.setPayInfoDto(payInfoDto);

        productDto.setSupplier(supplierDto);
        return productDto;
    }
}
