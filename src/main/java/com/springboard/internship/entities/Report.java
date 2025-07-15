//package com.springboard.internship.entities;
//
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//
//
//@Entity
//@Table(name="report1")
//public class Report {
//
//	 @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//
//	    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	    private List<Order> orders;
//
//	    private int totalOrders;   // Total number of orders
//	    private long uniqueUsers;  // Unique users based on email
//		public Report() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//		public Report(Long id, List<Order> orders, int totalOrders, long uniqueUsers) {
//			super();
//			this.id = id;
//			this.orders = orders;
//			this.totalOrders = totalOrders;
//			this.uniqueUsers = uniqueUsers;
//		}
//		public Long getId() {
//			return id;
//		}
//		public void setId(Long id) {
//			this.id = id;
//		}
//		public List<Order> getOrders() {
//			return orders;
//		}
//		public void setOrders(List<Order> orders) {
//			this.orders = orders;
//		}
//		public int getTotalOrders() {
//			return totalOrders;
//		}
//		public void setTotalOrders(int totalOrders) {
//			this.totalOrders = totalOrders;
//		}
//		public long getUniqueUsers() {
//			return uniqueUsers;
//		}
//		public void setUniqueUsers(long uniqueUsers) {
//			this.uniqueUsers = uniqueUsers;
//		}
//		@Override
//		public String toString() {
//			return "Report [id=" + id + ", orders=" + orders + ", totalOrders=" + totalOrders + ", uniqueUsers="
//					+ uniqueUsers + "]";
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
