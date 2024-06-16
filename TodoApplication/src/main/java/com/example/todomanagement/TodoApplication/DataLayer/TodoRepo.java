package com.example.todomanagement.TodoApplication.DataLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todomanagement.TodoApplication.model.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer>{
		
	List<Todo> findByUsername(String username);
}
