package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.model.Todo;
import com.example.domain.service.TodoService;
import com.example.form.TodoDetailForm;

import groovy.util.logging.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class TodoContoller {

	@Autowired
	private TodoService todoService;

	@Autowired
	private ModelMapper modelMapper;

	// 一覧画面の表示
	@GetMapping("/")
	public String getTodo(Model model) {
		List<Todo> getFalseTodos = todoService.getFalseTodos();
		List<Todo> getTrueTodos = todoService.getTrueTodos();
		model.addAttribute("Falsetodos", getFalseTodos);
		model.addAttribute("Truetodos", getTrueTodos);
		return "todo/todo";

	}

	// 追加画面の表示
	@GetMapping("/add")
	public String getAdd(Model model) {
		return "todo/add";
	}

	// 
	@GetMapping("/detail/{id}")
	public String getdetail(TodoDetailForm form, Model model,
			@PathVariable("id") int id) {
        
		//1件取得
		Todo todo = todoService.getTodoDetail(id);

		//Todoをformに変換
		form = modelMapper.map(todo, TodoDetailForm.class);

		//Modelに登録
		model.addAttribute("todoDetailForm", form);

		return "todo/detail";
	}

	// TODOの追加
	//	@PostMapping("/add")
	//	public String postadd() {
	//		//TODOの追加
	//		TodoService.getAddTodos(todo);
	//		//一覧画面にリダイレクト
	//		return "redirect:/todo";
	//	}
}