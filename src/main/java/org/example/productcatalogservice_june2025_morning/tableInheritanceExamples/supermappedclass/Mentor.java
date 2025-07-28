package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.supermappedclass;

import jakarta.persistence.Entity;

@Entity(name = "sm_mentor")
public class Mentor extends User{
    private Long hours;
}
