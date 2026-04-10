package com.solutions.mbangi.service;

import com.solutions.mbangi.domain.Category;
import com.solutions.mbangi.domain.Product;
import com.solutions.mbangi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

   // public ProductService(ProductRepository productRepository) {
    //    this.productRepository = productRepository;
    //}

    @Override
    public Product create(Product obj) {
        return  productRepository.save(obj);
    }

    @Override
    public Product read(Long aLong) {
        return productRepository.findById(aLong).orElse(null);
    }

    @Override
    public Product update(Product obj) {
        if (obj.getProductId() == null) {
            return null;
        }
        return productRepository.save(obj);
    }
    @Override
    public boolean delete(Long id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public List<Product> findByCategory_CategoryId(Long categoryId) {
        return productRepository.findByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategory_CategoryId(categoryId);
    }


}