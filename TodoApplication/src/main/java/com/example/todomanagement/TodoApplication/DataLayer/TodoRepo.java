package com.example.todomanagement.TodoApplication.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todomanagement.TodoApplication.model.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer>{

}
