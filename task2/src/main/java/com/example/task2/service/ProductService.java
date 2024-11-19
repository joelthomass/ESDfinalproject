package com.example.task2.service;
import com.example.task2.model.Product;
import com.example.task2.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getTop2Products(double minPrice, double maxPrice) {
        return productRepository.findTop2ByPriceRange(minPrice, maxPrice);
    }
}