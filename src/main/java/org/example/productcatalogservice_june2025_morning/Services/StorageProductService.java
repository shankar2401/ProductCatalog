package org.example.productcatalogservice_june2025_morning.Services;

import org.example.productcatalogservice_june2025_morning.models.Product;
import org.example.productcatalogservice_june2025_morning.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements iProductService{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if(productOptional.isPresent()) {
            return productOptional.get();
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Product> productOptional = productRepo.findById(product.getId());
        if(productOptional.isPresent()) {
            return productOptional.get();
        }
        return productRepo.save(product);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product deleteProductById(Long id) {
        return null;
    }
}
