package com.springboard.internship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String orderId;
    private String email;
    private String name;
    private Double totalAmount;
    private String hotelName;

    // Constructors
    public Order() {}

    public Order(String orderId, String email, String name, Double totalAmount,String hotelName) {
        this.orderId = orderId;
        this.email = email;
        this.name = name;
        this.totalAmount = totalAmount;
        this.hotelName=hotelName;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName =hotelName;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", email=" + email + ", name=" + name + ", totalAmount="
				+ totalAmount + ",hotelName="+hotelName+"]";
	}

	
    
}




















