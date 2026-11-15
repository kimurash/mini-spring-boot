package com.example.zkcoffee.repository;

import com.example.zkcoffee.entity.Product;
import java.util.HashMap;
import java.util.Map;
import minispring.stereotype.Repository;

@Repository
public class ProductRepository {
    private final Map<Long, Product> products = new HashMap<>(Map.of(
            1L, new Product(1L, "coffee", 10),
            2L, new Product(2L, "espresso", 5),
            3L, new Product(3L, "latte", 8)));

    public Product findById(long id) {
        return this.products.get(id);
    }

    public void decrease(long id) {
        Product product = this.products.get(id);
        this.products.put(id, new Product(id, product.name(), product.stock() - 1));
    }
}
