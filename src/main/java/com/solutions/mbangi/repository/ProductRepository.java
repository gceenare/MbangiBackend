package com.solutions.mbangi.repository;

import com.solutions.mbangi.domain.Category;
import com.solutions.mbangi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

     List<Product> findByName(String name);

     List<Product> findByCategory(Category category);

     List<Product> findByCategory_CategoryId(Long categoryId);

     List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
