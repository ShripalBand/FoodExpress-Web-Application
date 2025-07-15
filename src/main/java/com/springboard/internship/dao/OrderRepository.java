package com.springboard.internship.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboard.internship.entities.Order;



public interface OrderRepository extends JpaRepository<Order, Long> {
//	@Query("SELECT o FROM orders7 o WHERE o.orderDate BETWEEN :startDate AND :endDate")
//	List<Order> findOrdersBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
	 List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);

	
	// List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
}



































