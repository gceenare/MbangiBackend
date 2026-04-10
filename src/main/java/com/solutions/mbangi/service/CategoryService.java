package com.solutions.mbangi.service;

import com.solutions.mbangi.domain.Category;
import com.solutions.mbangi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category create(Category obj) {
        return this.repository.save(obj);
    }

    @Override
    public Category read(Long aLong) {
        return this.repository.findById(aLong).orElse(null);
    }

    @Override
    public Category update(Category obj) {
        return this.repository.save(obj);
    }


    @Override
    public boolean delete(Long aLong) {
        repository.deleteById(aLong);
        return !repository.existsById(aLong);
    }
    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
