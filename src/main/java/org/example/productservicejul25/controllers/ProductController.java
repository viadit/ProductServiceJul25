package org.example.productservicejul25.controllers;

import org.example.productservicejul25.dtos.CreateProductRequestDTO;
import org.example.productservicejul25.dtos.ErrorDTO;
import org.example.productservicejul25.exceptions.ProductNotFoundException;
import org.example.productservicejul25.models.Product;
import org.example.productservicejul25.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        Product product = productService.getSingleProduct(id);

        ResponseEntity<Product> productResponseEntity;
        if (product == null) {
            productResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            productResponseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        }

        return productResponseEntity;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO) {
        return productService.createProduct(createProductRequestDTO.getTitle(),
                createProductRequestDTO.getDescription(),
                createProductRequestDTO.getImage(),
                createProductRequestDTO.getCategory(),
                createProductRequestDTO.getPrice());
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException exception) {
//        ErrorDTO errorDTO = new ErrorDTO();
//
//        errorDTO.setMessage(exception.getMessage());
//        ResponseEntity<ErrorDTO> errorResponseEntity = new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
//        return errorResponseEntity;
//    }
}
