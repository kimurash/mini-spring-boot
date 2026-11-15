package com.example.zkcoffee.repository;

import com.example.zkcoffee.entity.Product;
import java.util.ArrayList;
import java.util.List;
import minispring.stereotype.Repository;

@Repository
public class OrderRepository {
    private final List<String> orders = new ArrayList<>();

    public void save(Product product) {
        this.orders.add(product.name());
    }

    public int count() {
        return this.orders.size();
    }
}
