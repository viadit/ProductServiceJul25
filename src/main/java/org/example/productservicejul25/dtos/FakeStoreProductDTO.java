package org.example.productservicejul25.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productservicejul25.models.Category;
import org.example.productservicejul25.models.Product;

@Getter
@Setter
// This class is a Data Transfer Object (DTO) for a product from the Fake Store API
public class FakeStoreProductDTO {

    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    // Converts this DTO to a Product model object manually
    public Product toProduct() {
        Product product = new Product();
        product.setName(this.title);
        product.setDescription(this.description);
        product.setImageUrl(this.image);
        product.setCategory(new Category(0, this.category));
        product.setPrice(this.price);
        return product;
    }
}
