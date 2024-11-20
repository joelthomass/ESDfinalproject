package com.example.task2.repository;

import com.example.task2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price ASC LIMIT 2", nativeQuery = true)
    List<Product> findPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
}

