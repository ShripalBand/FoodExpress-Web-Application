package com.springboard.internship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboard.internship.dao.OrderRepository;
import com.springboard.internship.entities.Order;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(String email, String name, Double totalAmount, String hotelName) {
        String orderId = "ORD" + System.currentTimeMillis(); // Generate random Order ID
        Order order = new Order(orderId, email, name, totalAmount,hotelName);
        orderRepository.save(order);
    }
}















