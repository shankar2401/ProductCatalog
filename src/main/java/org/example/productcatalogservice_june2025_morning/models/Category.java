package org.example.productcatalogservice_june2025_morning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity

public class Category extends BaseClass {
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Product> products;

    public Category() {
        this.setCreatedAt(new Date());
        this.setLastUpdatedAt(new Date());
        this.setState(State.ACTIVE);
        this.products = new ArrayList<Product>();
    }
}
