package com.springboard.internship.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboard.internship.entities.Order;



public interface OrderRepository extends JpaRepository<Order, Long> {
	//List<Dish> findByRestaurantId(Long restaurantId);
}


















