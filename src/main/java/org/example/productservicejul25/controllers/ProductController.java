package org.example.productservicejul25.controllers;

import org.example.productservicejul25.dtos.CreateProductRequestDTO;
import org.example.productservicejul25.models.Product;
import org.example.productservicejul25.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // This method should return a list of all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // This method should return a product by its ID
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getSingleProduct(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO) {
        return productService.createProduct(createProductRequestDTO.getTitle(),
                createProductRequestDTO.getDescription(),
                createProductRequestDTO.getImage(),
                createProductRequestDTO.getCategory(),
                createProductRequestDTO.getPrice());
    }
}
