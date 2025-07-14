package org.example.productservicejul25.services;

import org.example.productservicejul25.dtos.CreateProductRequestDTO;
import org.example.productservicejul25.dtos.FakeStoreProductDTO;
import org.example.productservicejul25.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate; // This is used to make HTTP requests to the fake store API

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);
        return fakeStoreProductDTO.toProduct();
    }

    @Override
    public Product createProduct(CreateProductRequestDTO createProductRequestDTO) {
        return null;
    }
}
