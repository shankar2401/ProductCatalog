package org.example.productcatalogservice_june2025_morning.Services;

import org.example.productcatalogservice_june2025_morning.dtos.SearchRequestDto;
import org.example.productcatalogservice_june2025_morning.dtos.SortParams;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ISerachService {
    //public List<Product> searchProducts(String name);
    public Page<Product> findAllByNameContains(String name, Integer pagenumber, Integer pagesize,List<SortParams> sortParams);
}
