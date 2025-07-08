package org.example.productcatalogservice_june2025_morning.Services;

import org.example.productcatalogservice_june2025_morning.client.FakeStoreClient;
import org.example.productcatalogservice_june2025_morning.dtos.FakeStoreProductDto;
import org.example.productcatalogservice_june2025_morning.models.Category;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements iProductService{
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Autowired
    FakeStoreClient fakeStoreClient;
    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        if (fakeStoreProductDtos != null) {
            List<Product> products = new ArrayList<>();
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                products.add(from(fakeStoreProductDto));
            }
            return products;
        }
        /*ResponseEntity<List<FakeStoreProductDto>> listRespnoseEntity = restTemplate.exchange("https://fakestoreapi.com/products", HttpMethod.GET, null, new ParameterizedTypeReference<List<FakeStoreProductDto>>() {});
        List<FakeStoreProductDto> fakeStoreProductDtos = listRespnoseEntity.getBody();
        List<Product> products = new ArrayList<>();
        if (fakeStoreProductDtos != null) {
            for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                Product product = from(fakeStoreProductDto);
                products.add(product);
            }
        }*/
        return null;
    }

    @Override
    public Product getProductById(Long proudctID) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.getProductById(proudctID);
        if (fakeStoreProductDto == null) {
            return null;
        }
        return from(fakeStoreProductDto);
    }
    //before client service layer implementation
   /* public Product getProductById(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        *//*FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/{productId}",
                FakeStoreProductDto.class,
                productId);*//*

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}",
                FakeStoreProductDto.class,
                productId);

        if (fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatus.valueOf(200)) &&  fakeStoreProductDtoResponseEntity.hasBody()) {
            return from(fakeStoreProductDtoResponseEntity.getBody());
        }
        return null;
    }*/



    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto inputfakeStoreProductDto = from(product);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.createProduct(inputfakeStoreProductDto);
        if (fakeStoreProductDto == null) {
            return null;
        }
        return from(fakeStoreProductDto);
    }
    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getName());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setUrl(product.getImageUrl());
        if (fakeStoreProductDto.getCategory() != null) {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }

        return fakeStoreProductDto;
    }
    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
            }

}
