package com.example.task2.service;

import com.example.task2.model.Product;
import com.example.task2.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    // Constructor injection for the repository
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Fetch top 2 products in the price range
    public List<Product> getTop2Products(double minPrice, double maxPrice) {
        return productRepository.findPriceRange(minPrice, maxPrice);
    }
}
