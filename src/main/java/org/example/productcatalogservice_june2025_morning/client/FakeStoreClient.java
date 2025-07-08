package org.example.productcatalogservice_june2025_morning.client;

import org.example.productcatalogservice_june2025_morning.dtos.FakeStoreProductDto;
import org.example.productcatalogservice_june2025_morning.models.Category;
import org.example.productcatalogservice_june2025_morning.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Component
public class FakeStoreClient {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductDto getProductById(Long productId) {

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = fakestoreresponseentity(HttpMethod.GET,"https://fakestoreapi.com/products/{productId}",
                null,
                FakeStoreProductDto.class,
                productId);

        if (validate(fakeStoreProductDtoResponseEntity)) {
            return fakeStoreProductDtoResponseEntity.getBody();
        }
        return null;
    }
    public FakeStoreProductDto createProduct(FakeStoreProductDto fakeStoreProductDto) {

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = fakestoreresponseentity(HttpMethod.POST,"https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class);

        if (validate(fakeStoreProductDtoResponseEntity)) {
            return fakeStoreProductDtoResponseEntity.getBody();
        }
        return null;
    }

    private  <T> ResponseEntity<T> fakestoreresponseentity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return (restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables));
    }

    private boolean validate(ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity) {
        if (fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatus.valueOf(200)) &&  fakeStoreProductDtoResponseEntity.hasBody()) {
            return true;
        }
        return false;
    }

}
