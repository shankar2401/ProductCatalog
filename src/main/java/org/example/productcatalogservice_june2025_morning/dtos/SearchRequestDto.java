package org.example.productcatalogservice_june2025_morning.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SearchRequestDto {
    private String  searchCriteria;
    private Integer  pagenumber;
    private Integer  pagesize;
    List<SortParams> searchParams;
}
