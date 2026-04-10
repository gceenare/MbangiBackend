package com.solutions.mbangi.service;

import com.solutions.mbangi.domain.Category;
import com.solutions.mbangi.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService extends IService<Product, Long> {

    List<Product> findByCategory_CategoryId(Long categoryId);
    List<Product> getProductsByCategory(Long categoryId);
    List<Product> getAll();

    void deleteAll();

}
