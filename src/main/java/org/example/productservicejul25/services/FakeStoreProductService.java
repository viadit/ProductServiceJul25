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
    FakeStoreProductDTO[] fakeStoreProductDTOs = restTemplate.getForObject
            ("https://fakestoreapi.com/products",
                    FakeStoreProductDTO[].class);
        return List.of(fakeStoreProductDTOs).stream()
                .map(FakeStoreProductDTO::toProduct)
                .toList();
    }

    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);
        return fakeStoreProductDTO.toProduct();
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 String imageUrl,
                                 String category,
                                 double price) {

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setImage(imageUrl);
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setPrice(price);

        // Send a POST request to the fake store API to create a new product
        FakeStoreProductDTO createdProductDTO = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDTO,
                FakeStoreProductDTO.class);
        return createdProductDTO.toProduct();
    }
}
