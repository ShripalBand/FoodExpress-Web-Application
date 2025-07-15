package com.springboard.internship.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboard.internship.dao.OrderRepository;
import com.springboard.internship.entities.Order;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(String email, String name, Double totalAmount, String hotelName,List<String> menuItems,LocalDate orderDate) {
        String orderId = "ORD" + System.currentTimeMillis(); // Generate random Order ID
        Order order = new Order(orderId, email, name, totalAmount,hotelName, menuItems,orderDate);
        orderRepository.save(order);
    }
    
    
   

    public List<Order> getOrdersBetweenDates(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }
    
}















