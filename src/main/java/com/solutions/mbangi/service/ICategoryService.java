package com.solutions.mbangi.service;

import com.solutions.mbangi.domain.Category;

import java.util.List;

public interface ICategoryService extends IService<Category, Long> {

     List<Category> getAll();
     void deleteAll();
}
