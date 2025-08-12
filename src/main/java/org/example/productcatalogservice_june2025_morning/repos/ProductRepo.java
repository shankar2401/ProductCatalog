package org.example.productcatalogservice_june2025_morning.repos;

import org.example.productcatalogservice_june2025_morning.dtos.CategoryDto;
import org.example.productcatalogservice_june2025_morning.models.BaseClass;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    //Page<Product> findAllByName(String name, Pageable pageable);

    Page<Product> findByNameEquals(String name, Pageable pageable);

    Optional<Product> findById(Long aLong);

    Product save(Product product);

    List<Product> findByName(String name);

    List<Product> findAll();
    List<Product>  findByPriceBetween(Double minPrice, Double maxPrice);
    List<Product>  findAllByOrderByPrice();
    @Query("select p.description from Product p where p.id=:id")
    String getDescription(Long id);

    void deleteById(Long aLong);
    int deleteByName(String Name);
    @Modifying
    @Query("Delete from Product p where p.category.name=:name")
    void deleteByCategoryName(String name);
    @Modifying
    @Query("Delete from Product p where p.category.id=:categoryId")
    void deleteProductWhereIdMatchesCategoryId(Long categoryId);
    @Modifying
    @Query("delete from Product p where p.createdAt<:retainDate")
    int retainProductsAfter(Date retainDate);

}
