//package com.springboard.internship.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.springboard.internship.dao.OrderItemRepository;
//import com.springboard.internship.dao.OrderRepository;
//import com.springboard.internship.dao.UserRepository;
//import com.springboard.internship.entities.OrderItem;
//import com.springboard.internship.entities.User;
//
//import jakarta.persistence.criteria.Order;
//
//@Service
//public class OrderService {
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private OrderItemRepository orderItemRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public Order placeOrder(String email, List<OrderItem> items, double totalAmount, Long restaurantId) {
//        Order order = new Order();
//        order.setEmail(email);
//        order.setItems(items);
//        order.setTotalAmount(totalAmount);
//        order.setRestaurantId(restaurantId);
//
//        for (OrderItem item : items) {
//            item.setOrder(order);
//        }
//
//        return orderRepository.save(order);
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
