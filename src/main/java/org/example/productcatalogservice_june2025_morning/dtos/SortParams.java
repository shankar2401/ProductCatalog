package org.example.productcatalogservice_june2025_morning.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParams {
    private String criteria;
    private SortType sortType;
}
