package com.example.todomanagement.TodoApplication;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.todomanagement.TodoApplication.DataLayer.TodoRepo;
import com.example.todomanagement.TodoApplication.SecurityLayer.AuthenticationDetails;
import com.example.todomanagement.TodoApplication.model.Todo;

@Controller
public class TodoController {
	
	
	TodoRepo todoRepository;
	AuthenticationDetails authDetails;
	
	public TodoController(TodoRepo todoRepository,AuthenticationDetails authDetails) {
		super();
		this.todoRepository = todoRepository;
		this.authDetails=authDetails;
	}




	@RequestMapping(value="list-todos",method=RequestMethod.GET)
	public String displayTodosByUsername(ModelMap model){
		List<Todo> todosByUsername = todoRepository.findAll();
		model.put("username", authDetails.getUserName());
		model.put("todolist", todosByUsername);
		return "todosPage";
		
	}

}
