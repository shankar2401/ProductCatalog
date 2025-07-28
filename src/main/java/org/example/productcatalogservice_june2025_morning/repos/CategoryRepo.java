package org.example.productcatalogservice_june2025_morning.repos;

import org.example.productcatalogservice_june2025_morning.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Override
    Optional<Category> findById(Long aLong);
}
