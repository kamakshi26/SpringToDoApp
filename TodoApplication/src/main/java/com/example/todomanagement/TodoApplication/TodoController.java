package com.example.todomanagement.TodoApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todomanagement.TodoApplication.DataLayer.TodoRepo;
import com.example.todomanagement.TodoApplication.SecurityLayer.AuthenticationDetails;
import com.example.todomanagement.TodoApplication.model.Todo;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	
	
	TodoRepo todoRepository;
	AuthenticationDetails authDetails;
	String username;
	
	public TodoController(TodoRepo todoRepository,AuthenticationDetails authDetails) {
		super();
		this.todoRepository = todoRepository;
		this.authDetails=authDetails;
	
	}




	@RequestMapping(value="list-todos",method=RequestMethod.GET)
	public String displayTodosByUsername(ModelMap model){
		username=authDetails.getUserName();
		List<Todo> todosByUsername = todoRepository.findByUsername(username);
		model.put("username", authDetails.getUserName());
		model.put("todolist", todosByUsername);
		return "todosPage";
		
	}

	

	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String addNewTodo(ModelMap model){
		username=authDetails.getUserName();
		Todo todo=new Todo(username,"write your todo",false,LocalDate.now().plusYears(1));
		model.put("username", username);
		model.put("todo", todo);
		return "addtodo";
		
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String writeNewTodo(ModelMap model,@Valid Todo todo,BindingResult results){
		if(results.hasErrors()) {
			System.out.println(results);
			return "addtodo";
		}
		System.out.println(todo);
		todoRepository.save(todo);
		return "redirect:list-todos";
		
	}
	
	@RequestMapping(value="delete-todo")
	public String deleteTodo(ModelMap model, @RequestParam String id){
		todoRepository.deleteById(Integer.parseInt(id));
		return "redirect:list-todos";
//		return "todosPage";
		
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String updateNewTodo(ModelMap model, @RequestParam String id){
		username=authDetails.getUserName();
		Todo todo=todoRepository.findById(Integer.valueOf(id)).get();
		model.put("username", username);
		model.put("todo", todo);
		return "addtodo";
		
	}
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String saveUpdatedTodo(ModelMap model,@Valid Todo todo,BindingResult results){
		if(results.hasErrors()) {
			System.out.println(results);
			return "addtodo";
		}
		System.out.println(todo);
//		todoRepository.deleteById(todo.getId());
		todoRepository.save(todo);
		return "redirect:list-todos";
		
	}
	

}
