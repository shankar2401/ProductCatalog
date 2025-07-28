package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.supermappedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;


@MappedSuperclass
public class User  {
    @Id
    private UUID id;
    private String name;
    private String email;

}
