package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.noinherittance;

import jakarta.persistence.Entity;

@Entity(name = "ni_ta")
public class TA extends User{
    private Double rating;
}
