package org.example.productcatalogservice_june2025_morning.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product extends BaseClass {
    private String name;
    private String description;
    private Category category;
    private Double price;
    private String imageUrl;
    public Product() {
        this.setCreatedAt(new Date());
        this.setLastUpdatedAt(new Date());
        this.setState(State.ACTIVE);
    }
}
