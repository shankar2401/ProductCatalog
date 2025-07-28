package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.supermappedclass;

import jakarta.persistence.Entity;

@Entity(name="sm_ta")
public class TA extends User{
    private Double rating;
}
