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

    public Product addProduct(Product product) {
        return productRepository.save(product); // This will insert a new product into the database.
    }

    public void deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product with ID " + id + " does not exist");
        }
    }

    public Product updateProduct(Long id, String name, Double price) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " does not exist"));

        if (name != null && !name.isBlank()) {
            product.setName(name);
        }
        if (price != null && price >= 0) {
            product.setPrice(price);
        }

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
