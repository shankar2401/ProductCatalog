package org.example.productcatalogservice_june2025_morning.controllers;

import lombok.Delegate;
import org.example.productcatalogservice_june2025_morning.Services.iProductService;
import org.example.productcatalogservice_june2025_morning.dtos.FakeStoreProductDto;
import org.example.productcatalogservice_june2025_morning.dtos.ProductDto;
import org.example.productcatalogservice_june2025_morning.models.Category;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private iProductService iProductService;
    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        List<Product> products = iProductService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        if (products == null || products.isEmpty() || products.size() < 1) {
            throw  new NullPointerException("products is null or empty");
        }
        for (Product product : products) {
            productDtos.add(from(product));
        }
        return productDtos;
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto>  getProductById(@PathVariable(name = "id") Long productid) {

        if (productid <= 0) {
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            throw  new IllegalArgumentException("productid should be greater than 0");
        }
        Product product = iProductService.getProductById(productid);
        if (product == null) {
           // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            throw new NullPointerException("product is null");
        }

        ProductDto productDto = from(product);
        return  new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product input = from(productDto);

        Product output = iProductService.createProduct(input);
        if (output == null ) {
            throw new NullPointerException("product is null");
        }

        return from(output);
    }
    @DeleteMapping("/products/{id}")
    public ProductDto deleteProduct(@PathVariable(name = "id") Long productId) {
        if (productId <= 0){
            throw  new IllegalArgumentException("productid should be greater than 0");
        }
        Product product = iProductService.deleteProductById(productId);
        if (product == null){
            throw new NullPointerException("Product is null");
        }
        return from(product);
    }

    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable(name = "id") Long productid, @RequestBody ProductDto productDto) {
        if (productid <= 0) {
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            throw  new IllegalArgumentException("productid should be greater than 0");
        }
        Product input = from(productDto);
        Product output = iProductService.replaceProduct(productid, input);
        if (output == null) {
            // return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            throw new NullPointerException("product is null");
        }
        return from(output);
    }
    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory());
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }
    private Product from(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        if(productDto.getImageUrl() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            category.setDescription(productDto.getCategory().getDescription());
            product.setCategory(category);
        }
        return product;
    }
}
