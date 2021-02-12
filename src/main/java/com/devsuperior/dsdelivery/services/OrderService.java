package com.devsuperior.dsdelivery.services;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        List<Order> list  = orderRepository.findOrderWithProducts();
        return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
    }
}
