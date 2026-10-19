package com.example.demo.service;

import com.example.demo.model.ActivityLog;
import com.example.demo.model.Order;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ActivityLogRepository logRepository;

    // Constructor Manual menggantikan @RequiredArgsConstructor
    public OrderService(OrderRepository orderRepository, ActivityLogRepository logRepository) {
        this.orderRepository = orderRepository;
        this.logRepository = logRepository;
    }

    public Order createOrder(Order order) {
        order.setStatus("CREATED");
        Order savedOrder = orderRepository.save(order);

        ActivityLog log = new ActivityLog();
        log.setAction("CREATE_ORDER");
        log.setDescription("Order created for product: " + order.getProductName());
        log.setTimestamp(LocalDateTime.now());
        logRepository.save(log);

        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}