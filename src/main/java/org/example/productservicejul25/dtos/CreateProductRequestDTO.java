package org.example.productservicejul25.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// This class is a Data Transfer Object (DTO) for creating a new product
public class CreateProductRequestDTO {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
