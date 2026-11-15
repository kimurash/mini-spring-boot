package com.example.zkcoffee.controller;

import com.example.zkcoffee.response.GetStockResponse;
import com.example.zkcoffee.service.OrderService;
import minispring.beans.factory.annotation.Autowired;
import minispring.web.bind.annotation.GetMapping;
import minispring.web.bind.annotation.PostMapping;
import minispring.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private static final String COFFEE_ID = "05f5c1db-6a3e-4eae-a5a5-1947d4dbe13f";

    @Autowired
    private OrderService orderService;

    @GetMapping("/stock")
    public GetStockResponse getStock() {
        return new GetStockResponse(COFFEE_ID, this.orderService.getStock(COFFEE_ID));
    }

    @PostMapping("/orders")
    public String order() {
        this.orderService.order(COFFEE_ID);
        return "Ordered";
    }
}
