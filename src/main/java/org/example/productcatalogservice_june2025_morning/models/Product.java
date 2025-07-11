package org.example.productcatalogservice_june2025_morning.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Product extends BaseClass {
    private String name;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private Double price;
    private String imageUrl;
    public Product() {
        this.setCreatedAt(new Date());
        this.setLastUpdatedAt(new Date());
        this.setState(State.ACTIVE);
    }
}
