package com.springboard.internship.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboard.internship.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	 List<Restaurant> findByNameContainingIgnoreCase(String name);
}


















