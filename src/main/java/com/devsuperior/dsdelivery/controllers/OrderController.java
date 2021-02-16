package com.devsuperior.dsdelivery.controllers;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<OrderDto> insert(@RequestBody OrderDto dto) {
        dto = orderService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDto> setDelivered(@PathVariable Long id) {
        OrderDto dto = orderService.setDelivered(id);
        return ResponseEntity.ok().body(dto);
    }
}
