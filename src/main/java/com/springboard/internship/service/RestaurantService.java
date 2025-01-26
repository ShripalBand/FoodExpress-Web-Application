package com.springboard.internship.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboard.internship.dao.DishRepository;
import com.springboard.internship.dao.RestaurantRepository;
import com.springboard.internship.entities.Dish;
import com.springboard.internship.entities.Restaurant;

import jakarta.persistence.criteria.Path;

@Service
public class RestaurantService {
	 @Autowired
	    private RestaurantRepository restaurantRepository;
    private final java.nio.file.Path uploadDir = Paths.get("uploads/restaurant-logos");

    public RestaurantService() throws IOException {
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
    }

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
    
    public List<Restaurant> getAllRestaurants() {
        //Object restaurantRepository;
		return restaurantRepository.findAll();
    }
    
    public List<Restaurant> searchRestaurantsByName(String name) {
        return restaurantRepository.findByNameContainingIgnoreCase(name);
    }
    
    
    
    
    @Autowired
    private DishRepository dishRepository;
    
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

//    public List<Dish> getMenuByRestaurantId(Long id) {
//        return dishRepository.findByRestaurantId(id);
//    }
    
    
}





















