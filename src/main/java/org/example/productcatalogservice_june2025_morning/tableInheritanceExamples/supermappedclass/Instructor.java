package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.supermappedclass;

import jakarta.persistence.Entity;

@Entity(name="sm_instructor")
public class Instructor extends User{
    private String companyName;
}
