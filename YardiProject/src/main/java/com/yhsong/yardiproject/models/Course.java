package com.yhsong.yardiproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="courses")
public class Course {
	// MEMEBER VARIABLE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Name is required!")
	@Size(min = 5, max = 200)
	private String name;
	
	@NotNull(message="Content is required!")
	@Size(min = 5, max = 200)
	private String content;
	
	@NotNull(message="Price is required!")
	@Min(1)
	private double price;
	
	@NotNull(message="Description is required!")
	@Size(min = 5, max = 200)
	private String description;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// RELATIONSHIPS
	// ! MANY TO MANY
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "purchases_courses",
		joinColumns = @JoinColumn(name = "course_id"),
		inverseJoinColumns = @JoinColumn(name = "purchase_id")
	)
	private List<Purchase> purchases;
	
	// ! MANY TO ONE w/ CART
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	// EMPTY CONSTRUCTOR
	public Course() {}

	// FULL CONSTRUCTOR
	public Course(@NotNull(message = "Name is required!") @Size(min = 5, max = 200) String name,
			@NotNull(message = "Day of the week is required!") @Size(min = 5, max = 200) String content,
			@NotNull(message = "Price is required!") @Min(1) double price,
			@NotNull(message = "Description is required!") @Size(min = 5, max = 200) String description) {
		super();
		this.name = name;
		this.content = content;
		this.price = price;
		this.description = description;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	
}
