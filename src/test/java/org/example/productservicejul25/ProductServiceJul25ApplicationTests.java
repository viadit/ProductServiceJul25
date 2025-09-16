package org.example.productservicejul25;

import org.example.productservicejul25.models.Product;
import org.example.productservicejul25.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceJul25ApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries() {
        List<Product> products = productRepository.
                findAllByCategory_Title("Electronics");
        System.out.println("Products in Electronics category:");
        products.forEach(p -> System.out.println(p.getName()));
    }

}
