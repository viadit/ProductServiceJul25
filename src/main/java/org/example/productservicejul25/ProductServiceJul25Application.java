package org.example.productservicejul25;

import org.example.productservicejul25.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceJul25Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceJul25Application.class, args);

        Product p1 = new Product();

    }

}
