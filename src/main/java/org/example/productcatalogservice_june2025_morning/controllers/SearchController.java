package org.example.productcatalogservice_june2025_morning.controllers;

import org.example.productcatalogservice_june2025_morning.Services.ISerachService;
import org.example.productcatalogservice_june2025_morning.Services.SearchProductService;
import org.example.productcatalogservice_june2025_morning.dtos.ProductDto;
import org.example.productcatalogservice_june2025_morning.dtos.SearchRequestDto;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    ISerachService iSerachService;
    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {
        Page<Product> products = iSerachService.findAllByNameContains(searchRequestDto.getSearchCriteria(),searchRequestDto.getPagenumber(),searchRequestDto.getPagesize(),searchRequestDto.getSearchParams());
        return products;

    }
}
