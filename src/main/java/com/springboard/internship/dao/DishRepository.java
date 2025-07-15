package com.springboard.internship.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboard.internship.entities.Dish;
import com.springboard.internship.entities.Restaurant;

public interface DishRepository extends JpaRepository<Dish, Long>{

	 List<Dish> findByIdIn(List<Long> ids);

}






















