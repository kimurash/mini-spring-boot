package com.example.zkcoffee.controller;

import com.example.zkcoffee.entity.Product;
import com.example.zkcoffee.response.GetStockResponse;
import com.example.zkcoffee.service.OrderService;
import minispring.beans.factory.annotation.Autowired;
import minispring.web.bind.annotation.GetMapping;
import minispring.web.bind.annotation.PostMapping;
import minispring.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private static final long COFFEE_ID = 1L;

    @Autowired
    private OrderService orderService;

    @GetMapping("/stock")
    public GetStockResponse getStock() {
        Product product = this.orderService.getProduct(COFFEE_ID);
        return new GetStockResponse(product.name(), product.stock());
    }

    @PostMapping("/orders")
    public String order() {
        this.orderService.order(COFFEE_ID);
        return "Ordered";
    }
}
