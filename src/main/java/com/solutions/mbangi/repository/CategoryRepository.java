package com.solutions.mbangi.repository;

import com.solutions.mbangi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);

}
