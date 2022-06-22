package com.yhsong.projectmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
	// MEMEBER VARIABLE
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		    
		@NotNull(message="Title is required!")
		@Size(min = 5, max = 200)
		private String title;
		    
		@NotNull(message="Description is required!")
		@Size(min = 5, max = 200)
		private String description;
		    
		@NotNull(message="Date is required!")
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date dueDate;
		 
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;
		
		//RELATIONSHIP
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User creator;
		
		// EMPTY CONSTRUCTOR
		public Project() {}

		// FULL CONSTRUCTOR
		public Project(@NotNull(message = "Title is required!") @Size(min = 5, max = 200) String title,
				@NotNull(message = "Description is required!") @Size(min = 5, max = 200) String description,
				@NotNull(message = "Date is required!") Date dueDate) {
			super();
			this.title = title;
			this.description = description;
			this.dueDate = dueDate;
		}

		// GETTERS | SETTERS | OTHER METHODS
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getDueDate() {
			return dueDate;
		}

		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
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

		public User getCreator() {
			return creator;
		}

		public void setCreator(User creator) {
			this.creator = creator;
		}
		
		
}
