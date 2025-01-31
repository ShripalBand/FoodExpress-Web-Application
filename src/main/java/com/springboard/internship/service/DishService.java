package com.springboard.internship.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboard.internship.dao.DishRepository;
import com.springboard.internship.entities.Dish;

@Service
public class DishService {
	 @Autowired
	    private DishRepository dishRepository;
	private Path uploadDir;

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
	    
	    public String saveLogo(MultipartFile file) throws IOException {
	        String originalFileName = file.getOriginalFilename();
	        if (originalFileName == null) {
	            throw new IOException("File name is invalid!");
	        }

	        String fileName = UUID.randomUUID() + "-" + originalFileName;
	        java.nio.file.Path filePath = uploadDir.resolve(fileName);
	        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	       // return fileName; // Return the file name to store in the database
	        return "/uploads/restaurant-logos/" + fileName;

	    }
	    
	    
	    
}



















