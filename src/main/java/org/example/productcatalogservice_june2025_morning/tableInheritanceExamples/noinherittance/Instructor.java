package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.noinherittance;

import jakarta.persistence.Entity;

@Entity(name = "ni_instructor")
public class Instructor extends User{
    private String companyName;
}
