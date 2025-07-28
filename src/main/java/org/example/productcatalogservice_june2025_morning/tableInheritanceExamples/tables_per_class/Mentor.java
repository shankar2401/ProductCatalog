package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.tables_per_class;

import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity(name = "tpc_mentor")
public class Mentor extends User{
    private Long hours;
}
