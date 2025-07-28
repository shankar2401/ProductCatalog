package org.example.productcatalogservice_june2025_morning.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@MappedSuperclass

public abstract class BaseClass {
    @Id
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;


}
