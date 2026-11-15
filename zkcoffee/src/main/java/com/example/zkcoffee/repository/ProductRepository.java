package com.example.zkcoffee.repository;

import com.example.zkcoffee.entity.Product;
import minispring.stereotype.Repository;

@Repository
public class ProductRepository {
    private Product coffee = new Product("coffee", 10);

    public Product find() {
        return this.coffee;
    }

    public void decrease() {
        this.coffee = new Product(this.coffee.name(), this.coffee.stock() - 1);
    }
}
