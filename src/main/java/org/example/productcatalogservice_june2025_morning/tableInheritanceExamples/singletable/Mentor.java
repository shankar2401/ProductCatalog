package org.example.productcatalogservice_june2025_morning.tableInheritanceExamples.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_mentor")
@DiscriminatorValue("2")
public class Mentor extends User{
    private Long  hours;
}
