package com.example.controller;

import java.util.ArrayList;
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
	
//	@Autowired
//	private ModelMapper modelMapper;

	@GetMapping("/")
	public String getTodo(Model model) {
		List<Todo>todoList=todoService.getTodos();
		List<Boolean> doneFlage = new ArrayList<>();
		for(Todo todo : todoList) {
            doneFlage.add(todo.isDone());
        }
        model.addAttribute("todos", todoList);
        model.addAttribute("doneFlags", doneFlage);

		
//		//ユーザー一覧取得
//		List<Todo>todoList=todoService.getTodos();
//		
//		//Modelに登録
//		model.addAttribute("userList",todoList);
//		
//		List<Todo> incompleteTodos = todoService.getIncompleteTodos();
//        List<Todo> completedTodos = todoService.getCompletedTodos();
//        model.addAttribute("incompleteTodos", incompleteTodos);
//        model.addAttribute("completedTodos", completedTodos);
//        
		return "todo/todo";
		
	}
}