package com.example.zkcoffee.controller;

import com.example.zkcoffee.Products;
import com.example.zkcoffee.response.GetStockResponse;
import com.example.zkcoffee.service.OrderService;
import minispring.beans.factory.annotation.Autowired;
import minispring.web.bind.annotation.GetMapping;
import minispring.web.bind.annotation.PostMapping;
import minispring.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/stock")
    public GetStockResponse getStock() {
        return new GetStockResponse(Products.COFFEE_ID, this.orderService.getStock(Products.COFFEE_ID));
    }

    @PostMapping("/orders")
    public String order() {
        this.orderService.order(Products.COFFEE_ID);
        return "Ordered";
    }
}
