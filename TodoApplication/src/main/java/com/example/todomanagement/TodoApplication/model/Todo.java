package com.example.todomanagement.TodoApplication.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	int id;
	String username;
	@Size(min=10,message="enter atleast 10 characters!!")
	String description;
	@Column(name="completed")
	boolean isDone;
	@FutureOrPresent(message="enter future or present date!!")
	@Column(name="date")
	LocalDate targetDate;
	
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todo(String username, String description, boolean isDone, LocalDate targetDate) {
		super();
		this.username = username;
		this.description = description;
		this.isDone = isDone;
		this.targetDate = targetDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", isDone=" + isDone
				+ ", targetDate=" + targetDate + "]";
	}

}
