package org.example.productcatalogservice_june2025_morning.repos;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice_june2025_morning.models.Category;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.example.productcatalogservice_june2025_morning.models.State;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepoTest {
    @Autowired
    ProductRepo productRepo;
    @Test
    public void getdescription() {
        System.out.println(productRepo.getDescription(8L));

    }
    @Test
    public void getProductsByName(){
        List<Product> products= productRepo.findByName("nnm");
        for (int i=0;i<products.size();i++ ) {
            System.out.println(
                    products.get(i).getName()
            );
        }
    }
    @Test
    @Transactional
    @Modifying
    public void deleteProductById() {
        Calendar calendar = Calendar.getInstance(); // Gets a calendar instance, usually initialized to current time
        calendar.set(2025, Calendar.JULY, 16, 0, 0, 0); // Year, Month (0-indexed), Day, Hour, Minute, Second
        Date specificDate = calendar.getTime();
        System.out.println( productRepo.retainProductsAfter(specificDate));
    }
    @Test
    public void createProduct() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Iphone");
        product1.setDescription("Iphone new model");
        product1.setPrice(150000.0);
        product1.setState(State.ACTIVE);
        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("Phone");
        product1.setCategory(category1);
        productRepo.save(product1);
        Product product2 = new Product();
        product2.setId(10L);
        product2.setName("Levis");
        product2.setDescription("Apparel");
        product2.setPrice(150000.0);
        product2.setState(State.ACTIVE);
        Category category2 = new Category();
        category2.setId(10L);
        category2.setName("Apparel");
        product2.setCategory(category2);
        productRepo.save(product2);
    }

    /*public void test() {
        List<Product> products = productRepo.findAll();
        for (Product product : products) {
            System.out.println(product.getId());
        }
*/
}
