package org.example.productcatalogservice_june2025_morning.controllers;

import org.example.productcatalogservice_june2025_morning.Services.iProductService;
import org.example.productcatalogservice_june2025_morning.dtos.ProductDto;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;

    @MockBean
     iProductService iProductService;
    @Test
    public void Test_CreateProductRunSuccessfully(){
        //Arrange
        ProductDto input = new ProductDto();
        input.setId(2L);
        input.setName("test");
        input.setDescription("desc");
        input.setPrice(150000D);

        Product output = new Product();
        output.setId(2L);
        output.setName("test");
        output.setDescription("desc");
        output.setPrice(150000D);
       when(iProductService.createProduct(any(Product.class))).thenReturn(output);
       //Act
        ProductDto productDto = productController.createProduct(input);
        //Assert
        assertNotNull(productDto);
        assertEquals(2L, productDto.getId());
        assertEquals("test", productDto.getName());
        assertEquals("desc", productDto.getDescription());
        assertEquals(150000D, productDto.getPrice());
    }
    @Test
    public void TestGetProductByID_RunSuccessfully(){
        //Arrange
        Long id = 2L;
        Product product = new Product();
        product.setId(id);
        product.setName("test");
        product.setPrice(20000D);
        product.setDescription("desc");
        when(iProductService.getProductById(id)).thenReturn(product);
        //Act
        ResponseEntity<ProductDto> productDtoResponseEntity = productController.getProductById(id);
        //Arrange
        assertNotNull(productDtoResponseEntity);
        assertNotNull(productDtoResponseEntity.getBody());
        assertEquals(id, productDtoResponseEntity.getBody().getId());
        assertEquals("test", productDtoResponseEntity.getBody().getName());
        assertEquals("desc", productDtoResponseEntity.getBody().getDescription());
        assertEquals(20000D, productDtoResponseEntity.getBody().getPrice());

    }
    @Test
    public void TestGetProductByID_IllegalArgumentException(){
        //Act
        Long id = -2L;
        //Arrange
        Assertions.assertThrows(IllegalArgumentException.class, () -> productController.getProductById(id));
    }

}