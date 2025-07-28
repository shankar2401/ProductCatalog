package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.noinherittance;

import jakarta.persistence.Entity;

@Entity(name="ni_mentor")
public class Mentor extends User {
    private Long hours;
}
