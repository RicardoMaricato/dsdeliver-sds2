package com.devsuperior.dsdelivery.controllers;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    public OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll() {
        List<OrderDto> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
