package com.devsuperior.dsdelivery.dto;

import com.devsuperior.dsdelivery.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDto(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imageUri = entity.getImageUri();
    }
}
