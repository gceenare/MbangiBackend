package com.solutions.mbangi.controller;

import com.solutions.mbangi.domain.Category;
import com.solutions.mbangi.factory.CategoryFactory;
import com.solutions.mbangi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category) {

        Category newCategory = CategoryFactory.createCategory(
                null,
                category.getName(),
                category.getDescription()
        );

        return service.create(newCategory);
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }

    @GetMapping("/all")
    public List<Category> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return service.read(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}