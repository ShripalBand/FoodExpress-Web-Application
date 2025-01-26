package com.springboard.internship.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboard.internship.dao.DishRepository;
import com.springboard.internship.dao.RestaurantRepository;
import com.springboard.internship.dao.UserRepository;
//import com.springboard.internship.entities.CustomerOrder;
import com.springboard.internship.entities.Dish;
//import com.springboard.internship.entities.OrderItem;
import com.springboard.internship.entities.Restaurant;
import com.springboard.internship.entities.User;
import com.springboard.internship.service.DishService;
//import com.springboard.internship.service.OrderService;
//import com.springboard.internship.service.OrderService;
import com.springboard.internship.service.RestaurantService;
import com.springboard.internship.service.UserService;

import jakarta.persistence.criteria.Order;
import jakarta.servlet.http.HttpSession;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;



@Controller
public class HomeController {
	
	@Autowired
    private HttpSession session;
	
	@RequestMapping("/home")
	public String home() {
		
		return "Home";
	}
	@RequestMapping("/login")
	public String login() {
		
		return "Login";
	}
	@RequestMapping("/SignUp")
	public String signUp() {
		
		return "SignUp";
	}
	
	@Autowired
	private UserRepository userrepo;
	
	 @Autowired
	    private DishService dishService;
	
	@PostMapping("/do_register")
	public String registration(@ModelAttribute("user")User user) {
		user.setRole("USER");
		userrepo.save(user);
		return "Login";
	}
	
	@Autowired
	private UserRepository userRepository ;
	
	@PostMapping("/check_user")
	public String loginUser(@ModelAttribute("user")User user,Model model,HttpSession session) {
		String username = user.getEmail();
		String password = user.getPassword();
//		System.out.println(username);
//		System.out.println(password);
		
		ArrayList<User>allUserList =(ArrayList<User>) userrepo.findAll();
		
			for(int i =  0 ; i<allUserList.size();i++) {
				// if user try to login
				if(allUserList.get(i).getEmail().equals(username)&&  allUserList.get(i).getRole().equals("USER") &&allUserList.get(i).getPassword().equals(password)){
					//user ui
					
					 User user1 = userRepository.findByEmail(username);
					 session.setAttribute("loggedInUser", user1);
			            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
			      
			            
			            model.addAttribute("restaurants", restaurants);
			            session.setAttribute("loggedInUser", user1); // Store user in session
			           // return "redirect:/dashboard";
			            return "userui";
			        
					//return "UserUI";
					
				}else if(allUserList.get(i).getEmail().equals(username)&&  allUserList.get(i).getRole().equals("ADMIN") &&allUserList.get(i).getPassword().equals(password)){
					//admin ui
					
					 model.addAttribute("dishes", dishService.getAllDishes());
				    	
				        return "menu";
					//return "AdminUI";
				}	
				
			}//End for loop
		
			 // If no match is found, add an error message
		    model.addAttribute("errorMessage", "Invalid username or password. Please try again.");
		    return "Login"; // Return to the login page with an error message
		
		
		//return "Login";
	}
	
	 

	    @GetMapping("/update-profile")
	    public String showUpdateProfileForm(Model model) {
	        // Retrieve the logged-in user from the session
	        User loggedInUser = (User) session.getAttribute("loggedInUser");

	        if (loggedInUser != null) {
	            // Pass the user object to the view
	            model.addAttribute("user", loggedInUser);
	            return "updateProfile"; // Thymeleaf template for the update profile page
	        } else {
	            // If user is not logged in, redirect to login page
	            return "redirect:/login";
	        }
	    }
	  
	  
	  
	    @Autowired
        private UserService userService;
	    
	    
	    @PostMapping("/update-profileIntoDatabase")
	    public String updateProfile(@ModelAttribute User updatedUser, RedirectAttributes redirectAttributes) {
	        User loggedInUser = (User) session.getAttribute("loggedInUser");
	        if (loggedInUser != null) {
	            // Update the fields of the logged-in user with updatedUser data
	            loggedInUser.setName(updatedUser.getName());
	            loggedInUser.setContact(updatedUser.getContact());
	            loggedInUser.setAddress(updatedUser.getAddress());
	            
	            // Save the updated user
	            userService.updateUserProfile(loggedInUser);

	            // Update the session with the new details
	            session.setAttribute("loggedInUser", loggedInUser);

	            // Redirect with success message
	            redirectAttributes.addFlashAttribute("message", "Profile updated successfully!");
	            //return "redirect:/UserUI";
	            return "updateProfile";
	        } else {
	            return "redirect:/login";
	        }
	    }
	    
	    
//	    @RequestMapping("/backprofile")
//		public String backIntoProfile() {
//			
//			return "UserUI";
//		}
		


	
	//*****************************restaurant menu model ********************************
//	 @Autowired
//	    private DishService dishService;

	    @GetMapping("/menu")
	    public String showMenu(Model model) {
	   
	        model.addAttribute("dishes", dishService.getAllDishes());
	    	
	        return "menu";
	    }

	    @PostMapping("/add")
	    public String addDish(@ModelAttribute("dish")Dish dish) {
//	        dishService.saveDish(dish);
	    	 dishService.saveDish(dish);
	        return "redirect:/menu";
	    }

	    @PostMapping("/delete/{id}")
	    public String deleteDish(@PathVariable Long id) {
	        dishService.deleteDish(id);
	        return "redirect:/menu";
	    }

	    @GetMapping("/update/{id}")
	    public String updateDishForm(@PathVariable Long id, Model model) {
	        model.addAttribute("dish", dishService.getDishById(id).orElse(null));
	        return "updatedish";
	    }

	    @PostMapping("/update")
	    public String updateDish(Dish dish) {
	        dishService.saveDish(dish);
	        return "redirect:/menu";
	    }
	    
	    
	    

	    
	    
	  //*****************************restaurant model ********************************
	   
	        @Autowired
	        private RestaurantService restaurantService;
	        @Autowired
	        private RestaurantRepository restaurantRepository;
	        
	    	@RequestMapping("/res")
	    	public String addReato() {
	    		
	    		return "AddRestaurant";
	    	}
	    	
//	    	@RequestMapping("/display")
//	        public String getRestaurants(Model model) {
//	            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
//	            model.addAttribute("restaurants", restaurants);
//	            return "UserUI";
//	           
//	        }
	    	@RequestMapping("/restaurants")
	    	 public String getRestaurants(@RequestParam(required = false) String search, Model model) {
	            List<Restaurant> restaurants;
	            if (search != null && !search.isEmpty()) {
	                restaurants = restaurantService.searchRestaurantsByName(search);
	            } else {
	                restaurants = restaurantService.getAllRestaurants();
	            }
	            model.addAttribute("restaurants", restaurants);
	            return "userui";
	        }
	    	
	    	

	        @PostMapping("/add-restaurant")
	        public String addRestaurant(@RequestParam("name") String name, @RequestParam("contact") String contact, @RequestParam("address") String address,
	                                    @RequestParam("logo") MultipartFile logo) throws IOException {
	            String logoPath = restaurantService.saveLogo(logo);
	            Restaurant restaurant = new Restaurant();
	            restaurant.setName(name);
	            restaurant.setLogoPath(logoPath);
	            restaurant.setContact(contact);
	            restaurant.setAddress(address);
	            restaurantRepository.save(restaurant);
	            return "AddRestaurant";
	        }
	        
	        
	        
	        
	        
	      //********************************************** Order management module *********************************

	        
	        
	       
	        
	        
	        @GetMapping("/{id}/order")
	        public String getRestaurantOrderPage(@PathVariable Long id, Model model,HttpSession session) {
	            // Fetch restaurant details
	            Restaurant restaurant = restaurantService.getRestaurantById(id);
	            
	            // Add restaurant details to session
	            session.setAttribute("restaurant", restaurant);
	            // Fetch menu items for the restaurant
	           // List<Dish> menuItems = restaurantService.getMenuByRestaurantId(id);
	          //  List<Dish> menuItems = dishRepository.findAll();
	            List<Dish> menuItems = dishService.getAllDishes();
	            // Add to the model
	           // model.addAttribute("restaurant", restaurant);
	            model.addAttribute("menuItems", menuItems);

	            return "orderPage"; // Thymeleaf template name
	        }
	        
	        
	        
	        
	        
	        @Autowired
	        private DishRepository dishRepository;
	        
	        
//	        List<Dish> dishes = new ArrayList<>();
//	        private Map<Long, Integer> quantities = new HashMap<>();
	        @PostMapping("/calculate-order")
	        public String calculateOrder(
	                @RequestParam(value = "selectedDishes", required = false) List<Long> selectedDishes,
	                @RequestParam(value = "quantity", required = false) List<Integer> quantities,
	                Model model) {

	            double totalAmount = 0.0;
	            List<Dish> dishes = new ArrayList<>();

	            if (selectedDishes != null && quantities != null) {
	                dishes = dishRepository.findAllById(selectedDishes);

	                for (int i = 0; i < dishes.size(); i++) {
	                    totalAmount += dishes.get(i).getPrice() * quantities.get(i);
	                }
	            }

	            model.addAttribute("dishes", dishes);
	            model.addAttribute("quantities", quantities != null ? quantities : new ArrayList<>());
	            model.addAttribute("totalAmount", totalAmount);

	            return "orderSummary";
	        }

	        
	        
//	     // Method to remove an item from the order
//	        public void removeItemFromOrder(Long dishId) {
//	            dishes.removeIf(dish -> dish.getId().equals(dishId));
//	            quantities.remove(dishId);
//	        }
//
//	        // Method to calculate the total amount of the order
//	        public double calculateTotalAmount() {
//	            double total = 0.0;
//	            for (Dish dish : dishes) {
//	                int quantity = quantities.getOrDefault(dish.getId(), 0);
//	                total += dish.getPrice() * quantity;
//	            }
//	            return total;
//	        }
//	        
//	        
//	        
//	        @PostMapping("/remove-item")
//	        public String removeItem(@RequestParam("dishId") Long dishId, Model model) {
//	            // Remove the item from the order
//	            removeItemFromOrder(dishId);
//	            
//	            // Update the total amount
//	            double totalAmount = calculateTotalAmount();
//	            
//	            // Add the updated total amount and dishes to the model
//	            model.addAttribute("dishes", dishes);
//	           // model.addAttribute("quantities",getQuantities());
//	            model.addAttribute("quantities", quantities != null ? quantities : new ArrayList<>());
//	            model.addAttribute("totalAmount", totalAmount);
//
//	            // Return to the order summary page
//	            return "orderSummary";
//	        }
	        
	        

//	        @PostMapping("/calculate-order")
//	        public String calculateOrder(
//	            @RequestParam("selectedDishes") List<Long> selectedDishes,
//	            @RequestParam("quantity") List<Integer> quantities,
//	            Model model) {
//
//	            double totalAmount = 0.0;
//
//	            // Fetch selected dishes and calculate total amount
//	            List<Dish> dishes = dishRepository.findAllById(selectedDishes);
//	            for (int i = 0; i < dishes.size(); i++) {
//	                totalAmount += dishes.get(i).getPrice() * quantities.get(i);
//	            }
//
//	            // Add data to model
//	            model.addAttribute("dishes", dishes);
//	            model.addAttribute("quantities", quantities);
//	            model.addAttribute("totalAmount", totalAmount);
//
//	            return "orderSummary"; // Redirect to summary page
//	        }

	    
	        
	        @PostMapping("/cancel-order")
	        public String cancelOrder(Model model) {
	          //  model.addAttribute("message", "Your order has been cancelled.");
	            return "orderPage"; // Redirect to cancellation page
	        }
	        
	        
	        
	        
//	        @Autowired
//	        private OrderService orderService;
//	        
//	      
//
//	        @PostMapping("/pay")
//	        public String payOrder( @RequestParam List<Long> dishIds, @RequestParam List<Integer> quantities, Model model) {
//	        	 String email = (String) session.getAttribute("loggedInUser");
//	        	// Calculate total amount and create order items
//	            List<OrderItem> items = new ArrayList<>();
//	            double totalAmount = 0.0;
//	            for (int i = 0; i < dishIds.size(); i++) {
//	                java.util.Optional<Dish> dish = dishService.getDishById(dishIds.get(i));
//	                int quantity = quantities.get(i);
//	                totalAmount += dish.getPrice() * quantity;
//
//	                OrderItem item = new OrderItem();
//	                item.setDish(dish);
//	                item.setQuantity(quantity);
//	                items.add(item);
//	            }
//
//	            // Place the order
//	            Order order = orderService.placeOrder(email, items, totalAmount);
//
//	            // Redirect to order success page
//	            model.addAttribute("orderId", order.getId());
//	            model.addAttribute("totalAmount", totalAmount);
//	            return "orderSuccess"; // Create an order success page
//	        }

}





















