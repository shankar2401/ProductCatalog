package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.tables_per_class;

import jakarta.persistence.Entity;

@Entity(name = "tpc_TA")
public class TA extends User{
    private Double rating;
}
