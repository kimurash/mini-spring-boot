package com.example.zkcoffee.service;

import com.example.zkcoffee.entity.Product;
import com.example.zkcoffee.repository.OrderRepository;
import com.example.zkcoffee.repository.ProductRepository;
import minispring.beans.factory.annotation.Autowired;
import minispring.stereotype.Service;
import minispring.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void order(long productId) {
        this.productRepository.decrease(productId);
        this.orderRepository.save(this.productRepository.findById(productId));
    }

    public Product getProduct(long productId) {
        return this.productRepository.findById(productId);
    }
}
