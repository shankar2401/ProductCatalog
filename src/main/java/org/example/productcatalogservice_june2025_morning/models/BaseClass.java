package org.example.productcatalogservice_june2025_morning.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
