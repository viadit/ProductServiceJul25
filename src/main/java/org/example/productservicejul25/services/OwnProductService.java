package org.example.productservicejul25.services;

import org.example.productservicejul25.exceptions.ProductNotFoundException;
import org.example.productservicejul25.models.Category;
import org.example.productservicejul25.models.Product;
import org.example.productservicejul25.repositories.CategoryRepository;
import org.example.productservicejul25.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ownProductService")
public class OwnProductService implements ProductService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public OwnProductService (CategoryRepository categoryRepository,
                              ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 String imageUrl,
                                 String category,
                                 double price) {

        Product product = new Product();

        product.setName(title);
        product.setDescription(description);
        product.setImageUrl(imageUrl);
        product.setPrice(price);

        Category categoryFromDb = categoryRepository.findByTitle(category);

        if (categoryFromDb == null) {
            categoryFromDb = new Category();
            categoryFromDb.setTitle(category);
        }

        product.setCategory(categoryFromDb);
        Product createdProduct = productRepository.save(product);

        return createdProduct;
    }
}
