package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.model.Todo;
import com.example.domain.service.TodoService;

import groovy.util.logging.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class TodoContoller {
	
	@Autowired
	private TodoService todoService;
	

	@GetMapping("/")
	public String getTodo(Model model) {
		List<Todo>getFalseTodos=todoService.getTodos();
		List<Todo>getTrueTodos=todoService.getTrueTodos();

        model.addAttribute("todos", getFalseTodos);
        model.addAttribute("Truetodos", getTrueTodos);
		return "todo/todo";
		
	}
}