package com.springboard.internship.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders7")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String orderId;
    private String email;
    private String name;
    private Double totalAmount;
    private String hotelName;
    @ElementCollection
    private List<String> items;
    @Column(name = "menu_item")
    private List<String> menuItems;
    private LocalDate orderDate;
    
 

    // Constructors
    public Order() {
       // this.menuItems = new ArrayList<>(); // Ensure it's initialized
    }

    public Order(String orderId, String email, String name, Double totalAmount,String hotelName,List<String> menuItems, LocalDate orderDate) {
        this.orderId = orderId;
        this.email = email;
        this.name = name;
        this.totalAmount = totalAmount;
        this.hotelName=hotelName;
        this.menuItems = menuItems;
        this.orderDate = orderDate;
        
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
	
	 public List<String> getMenuItems() {
	        return menuItems;
	    }

	    public void setMenuItems(List<String> menuItems) {
	        this.menuItems = menuItems;
	    }
	    public LocalDate getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", email=" + email + ", name=" + name + ", totalAmount="
				+ totalAmount + ",hotelName="+hotelName+ ",menuItems="+menuItems+ ",orderDate="+orderDate+"]";
	}

	
    
}




















