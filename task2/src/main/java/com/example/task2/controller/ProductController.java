package com.example.task2.controller;

import com.example.task2.model.Product;
import com.example.task2.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {
        return productService.getTop2Products(minPrice, maxPrice);
    }
}