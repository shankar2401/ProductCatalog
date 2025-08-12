package org.example.productcatalogservice_june2025_morning.Services;

import org.example.productcatalogservice_june2025_morning.dtos.SortParams;
import org.example.productcatalogservice_june2025_morning.dtos.SortType;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.example.productcatalogservice_june2025_morning.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchProductService implements ISerachService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public Page<Product> findAllByNameContains(String name,Integer pagenumer, Integer pagesize,List<SortParams> sortParams) {
       // Sort sortbyId = Sort.by("id").descending();
        Sort sort = null;
        if(!sortParams.isEmpty()) {
            if(sortParams.get(0).getSortType().equals(SortType.ASC))
                sort = Sort.by(sortParams.get(0).getCriteria());
                else
                    sort = Sort.by(sortParams.get(0).getCriteria()).descending();

                for(int i = 1; i < sortParams.size(); i++){
                    if(sortParams.get(i).getSortType().equals(SortType.ASC))
                    sort = sort.and(Sort.by(sortParams.get(i).getCriteria()));
                    else
                        sort = sort.and(Sort.by(sortParams.get(i).getCriteria()).descending());
                }
        }

        return productRepo.findByNameEquals(name, PageRequest.of(pagenumer, pagesize, sort));
    }

    //@Override
//    public List<Product> searchProducts(String name) {
//        List<Product> products = productRepo.findByNameEquals(name);
//        return products;
//    }
}
