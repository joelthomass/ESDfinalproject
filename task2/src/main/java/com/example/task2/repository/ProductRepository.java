package com.example.task2.repository;

import com.example.task2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price ASC")
    List<Product> findTop2ByPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
}