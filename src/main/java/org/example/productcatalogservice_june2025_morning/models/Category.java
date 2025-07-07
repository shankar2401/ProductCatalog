package org.example.productcatalogservice_june2025_morning.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Category extends BaseClass {
    private String name;
    private String description;
    private List<Product> products;
}
