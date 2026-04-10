package com.solutions.mbangi.factory;

import com.solutions.mbangi.domain.Category;
import com.solutions.mbangi.domain.Product;
import com.solutions.mbangi.util.Helper;

public class ProductFactory {


        public static Product createProduct(String name,
                                            String description,
                                            double price,
                                            Category category) {

            if (Helper.isNullOrEmpty(name)
                    || Helper.isNullOrEmpty(description)
                    || price <= 0
                    || category == null) {

                return null;
            }

            return new Product.Builder()
                    .setName(name)
                    .setDescription(description)
                    .setPrice(price)
                    .setCategory(category)
                    .build();
        }
    }