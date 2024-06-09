package com.example.todomanagement.TodoApplication.WelcomePageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.todomanagement.TodoApplication.SecurityLayer.AuthenticationDetails;

@Controller
public class WelcomeController {
	
	@Autowired
	AuthenticationDetails authDetails;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		model.put("username", authDetails.getUserName());
		return "welcome";
	}

}
