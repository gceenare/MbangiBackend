package com.solutions.mbangi.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Product {

    private String productId;
    private String name;
    private String description;
    private double price;
    private Category category;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category Category;

    public Product(Builder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.category = builder.category;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString(){
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    public static class Builder{
        private String productId;
        private String name;
        private String description;
        private double price;
        private Category category;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

        public Builder copy(Product product) {
            this.productId = product.productId;
            this.name = product.name;
            this.description = product.description;
            this.price = product.price;
            this.category = product.category;
            return this;
        }
        public Product buildCopy() {
            return new Product(this);
        }

    }

}
