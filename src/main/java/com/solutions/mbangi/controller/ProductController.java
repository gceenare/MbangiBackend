package com.solutions.mbangi.controller;

import com.solutions.mbangi.domain.Category;
import com.solutions.mbangi.domain.Product;
import com.solutions.mbangi.factory.ProductFactory;
import com.solutions.mbangi.service.CategoryService;
import com.solutions.mbangi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {

        Product newProduct = ProductFactory.createProduct(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory()
        );

        if (newProduct == null) {
            throw new IllegalArgumentException("Invalid product data");
        }

        return service.create(newProduct);
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getByCategory(@PathVariable Long categoryId) {
        return service.getProductsByCategory(categoryId);
    }
}