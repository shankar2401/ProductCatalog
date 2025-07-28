package org.example.productcatalogservice_june2025_morning.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_june2025_morning.models.Category;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryRepoTest {
    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void CategoryfindbyId(){
        Category category = categoryRepo.findById(1L).get();
        for (Product product : category.getProducts()) {
            System.out.println(product.getName());
        }
    }

}