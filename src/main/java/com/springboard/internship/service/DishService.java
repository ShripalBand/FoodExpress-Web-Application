package com.springboard.internship.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboard.internship.dao.DishRepository;
import com.springboard.internship.entities.Dish;

@Service
public class DishService {
	 @Autowired
	    private DishRepository dishRepository;

	    public List<Dish> getAllDishes() {
	        return dishRepository.findAll();
	    }

	    public Dish saveDish(Dish dish) {
	        return dishRepository.save(dish);
	    }

	    public void deleteDish(Long id) {
	        dishRepository.deleteById(id);
	    }

	    public java.util.Optional<Dish> getDishById(Long id) {
	        return dishRepository.findById(id);
	    }
//	    public List<Dish> getDishesByIds(List<Long> dishIds) {
//	        return dishRepository.findByIdIn(dishIds);
//	    }
}



















