package org.example.productservicejul25.services;

import org.example.productservicejul25.dtos.CreateProductRequestDTO;
import org.example.productservicejul25.models.Product;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(long id);

    Product createProduct(String title,
                          String description,
                          String imageUrl,
                          String category,
                          double price);
}
