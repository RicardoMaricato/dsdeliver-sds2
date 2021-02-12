package com.devsuperior.dsdelivery.controllers;

import com.devsuperior.dsdelivery.dto.ProductDto;
import com.devsuperior.dsdelivery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
