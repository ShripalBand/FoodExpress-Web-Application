package com.springboard.internship.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboard.internship.entities.Dish;
import com.springboard.internship.entities.Restaurant;

public interface DishRepository extends JpaRepository<Dish, Long>{
//	 List<Dish> findByRestaurantId(Long restaurantId);
//	 List<Dish> findByRestaurant(Restaurant restaurant);
//	 List<Dish> findAll();

//	List<Dish> findAllById(List<Long> ids);
//	List<T> findAllById(Iterable<ID> ids);
//	   @Query("SELECT d FROM dish2 d WHERE d.id IN :ids")
//	    List<Dish> findAllById(@Param("ids") List<Long> ids);
	 List<Dish> findByIdIn(List<Long> ids);

}






















