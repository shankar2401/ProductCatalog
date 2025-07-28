package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.noinherittance;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "ni_user")
public abstract class User {
    @Id
    private UUID id;
    private String name;
    private String email;
}
