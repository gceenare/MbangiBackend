package com.solutions.mbangi.factory;

import com.solutions.mbangi.domain.Category;
import com.solutions.mbangi.util.Helper;

public class CategoryFactory {
    public static Category createCategory(Long categoryId, String name, String description) {

        if (!Helper.isValidId(categoryId) ||
                Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(description)) {
            return null; // ✅ IMPORTANT
        }

        return new Category.Builder()
                .setName(name)
                .setDescription(description)
                .build();
    }
}