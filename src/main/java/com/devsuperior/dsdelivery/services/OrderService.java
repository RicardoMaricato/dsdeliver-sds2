package com.devsuperior.dsdelivery.services;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.dto.ProductDto;
import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.entities.OrderStatus;
import com.devsuperior.dsdelivery.entities.Product;
import com.devsuperior.dsdelivery.repositories.OrderRepository;
import com.devsuperior.dsdelivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        List<Order> list  = orderRepository.findOrderWithProducts();
        return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDto insert(OrderDto dto) {
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for (ProductDto p : dto.getProducts()) {
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDto(order);
    }
}
