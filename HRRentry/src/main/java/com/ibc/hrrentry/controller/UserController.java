package com.ibc.hrrentry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ibc.hrrentry.entity.User;


	@Controller
	public class UserController {
		
		@RequestMapping(path="/register", method=RequestMethod.GET)
		
		public String doRegister(@ModelAttribute("register") User user,BindingResult result) {
			return null;
			
			
			
		}
		
		@RequestMapping(path="/saveUser", method=RequestMethod.POST)
		
		public String saveUser(@ModelAttribute("register") User user,@RequestParam("username") String username,BindingResult result) {
			String json = null;
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			try {
				json = ow.writeValueAsString(user);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(json);
			System.out.println(username);
			
			return "save";
		}
	}
