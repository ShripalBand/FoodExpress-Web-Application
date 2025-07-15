//package com.springboard.internship.service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.springboard.internship.dao.DishRepository;
//import com.springboard.internship.dao.OrderRepository;
//import com.springboard.internship.dao.UserRepository;
//import com.springboard.internship.entities.Dish;
//import com.springboard.internship.entities.Order;
//import com.springboard.internship.entities.Report;
//
//@Service
//public class ReportService {
//
////	@Autowired
////	private DishRepository dishRepository;	
////	
////	@Autowired
////	private UserRepository userRepository;
////	
////	@Autowired
////	private OrderRepository orderRepository;
////	
////    public List<Dish> getMenu() {
////       List<Dish> list = dishRepository.findAll();
////       return list;
////    }
////
////    public int getTotalCustomers() {
////    	 Iterable<com.springboard.internship.entities.User> list = userRepository.findAll();
////    	 int size = 0;
////    	 for (com.springboard.internship.entities.User user : list) {
////    	     size++;
////    	 }
////         return size;
////       // return 120; // Example static value
////    }
////
////    public List<Order> getAllOrders() {
////    	 List<Order> list = orderRepository.findAll();
////         return list;
////    }
//    
//    
//    //**********************************************************
//    @Autowired
//    private OrderRepository orderRepository;
//
//    public Report generateReport(LocalDate startDate, LocalDate endDate) {
//        List<Order> orders = orderRepository.findByOrderDateBetween(startDate, endDate);
//        
//        
//        if (orders == null) {
//            orders = List.of(); // Ensure it's not null
//        }
//
//        // Get unique users by email
//        long uniqueUsers = orders.stream().map(Order::getEmail).distinct().count();
//
//        Report report = new Report();
//        report.setOrders(orders);
//        report.setTotalOrders(orders.size());
//        report.setUniqueUsers(uniqueUsers);
//
//        return report;
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
