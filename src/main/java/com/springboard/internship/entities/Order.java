//package com.springboard.internship.entities;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//
//	    @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//
//	    private String email;
//
//	    private Long restaurantId;
//
//	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
//	    private List<OrderItem> items;
//
//	    private double totalAmount;
//
//		public Order(Long id, String email, Long restaurantId, List<OrderItem> items, double totalAmount) {
//			super();
//			this.id = id;
//			this.email = email;
//			this.restaurantId = restaurantId;
//			this.items = items;
//			this.totalAmount = totalAmount;
//		}
//
//		public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//		public String getEmail() {
//			return email;
//		}
//
//		public void setEmail(String email) {
//			this.email = email;
//		}
//
//		public Long getRestaurantId() {
//			return restaurantId;
//		}
//
//		public void setRestaurantId(Long restaurantId) {
//			this.restaurantId = restaurantId;
//		}
//
//		public List<OrderItem> getItems() {
//			return items;
//		}
//
//		public void setItems(List<OrderItem> items) {
//			this.items = items;
//		}
//
//		public double getTotalAmount() {
//			return totalAmount;
//		}
//
//		public void setTotalAmount(double totalAmount) {
//			this.totalAmount = totalAmount;
//		}  
//	    
//	    
//	    
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
//
//
//
//
//
//
//
//
