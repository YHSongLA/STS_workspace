package com.yhsong.yardiproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="carts")
public class Cart {
	// MEMEMBER VARIABLES
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Course[] cart;
	
	private int courseCount;
	
	private int capacity;
	
	@NotNull(message="Total is required!")
	@Min(1)
	private double totalPrice;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // RELATIONSHIPS
    // ! ONE TO ONE w/ PURCHASE
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="purchase_id")
    private Purchase purchase;
    
    // ! ONE TO MANY w/ COURSES
    @OneToMany(mappedBy="cart", fetch = FetchType.LAZY)
    private List<Course> courses;
    
    // EMPTY CONSTRUCTOR
    // ! CREATES AN EMPTY SHOPPING CART w/ CAPACITY OF 5 COURSES
    public Cart() {
    	capacity = 5;
    	cart = new Course[capacity];
    	courseCount = 0;
    	totalPrice = 0.0;
    }
    
    // GETTERS | SETTERS | OTHER METHODS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double total) {
		this.totalPrice = total;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public Course[] getCart() {
		return cart;
	}

	public void setCart(Course[] cart) {
		this.cart = cart;
	}

	public int getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(int courseCount) {
		this.courseCount = courseCount;
	}

	public int getCapacty() {
		return capacity;
	}

	public void setCapacty(int capacty) {
		this.capacity = capacty;
	}
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	// ADDS A COURSE TO THE SHOPPING CART
	public void addToCart(String name, String content, double price, String description) {
		Course temp = new Course(name, content, price, description);
		totalPrice += price;
		cart[courseCount] = temp;
		courseCount += 1;
		if (courseCount == capacity) {
			increaseSize();
		}
	}
	
	// INCREASES THE CAPACITY OF THE SHOPPING CART BY 3
	private void increaseSize() {
		Course[] temp = new Course[capacity+3];
		for (int i = 0; i < capacity; i++) {
			temp[i] = cart[i];
		}
		cart = temp;
		temp = null;
		capacity = cart.length;
	}
}