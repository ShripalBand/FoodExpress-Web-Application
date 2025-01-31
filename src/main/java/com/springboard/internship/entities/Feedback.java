package com.springboard.internship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedback1")
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String rating;
    private String review;
    public Feedback() {
    	
    }
    public Feedback(Long id, String name, String email, String rating, String review) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rating = rating;
		this.review = review;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + name + ", email=" + email + ", rating=" + rating + ", review="
				+ review + "]";
	}
    
    
	
    

    
}
















