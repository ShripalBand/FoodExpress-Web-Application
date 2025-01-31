package com.springboard.internship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="dish3")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

    private String logoPath;
    
    

    public Dish(){
    	
    }
	public Dish(boolean available, Long id, String name, String description, double price,String logoPath) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.logoPath = logoPath;


	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	

	
	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", logoPath=" + logoPath + "]";
	}
    
    

}
















