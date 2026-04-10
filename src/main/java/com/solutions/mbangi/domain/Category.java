package com.solutions.mbangi.domain;

import jakarta.persistence.*;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;


    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)    private List<Product> products;

    protected Category(){

    }

    public Category(Builder builder){
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.description = builder.description;
        this.products = builder.products;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return categoryId != null && categoryId.equals(category.categoryId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public static class Builder{
        private Long categoryId;
        private String name;
        private String description;
        private List<Product>products;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setProducts(List<Product> products) {
            this.products = products;
            return this;
        }

        public Category build(){
            return new Category(this);
        }
    }


}
