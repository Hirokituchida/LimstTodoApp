package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.model.Todo;
import com.example.domain.service.TodoService;
import com.example.form.AddForm;
import com.example.form.TodoDetailForm;

import lombok.extern.slf4j.Slf4j;

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
	public String getAdd(Model model, Locale locale, @ModelAttribute AddForm form) {

		return "todo/add";
	}

	//
	@PostMapping("/add")
	public String postAdd(Model model, Locale locale, @ModelAttribute @Validated AddForm form,
			BindingResult bindingResult) {

		try {
			Todo todo = modelMapper.map(form, Todo.class);

			todoService.getAdditionTodos(todo);
			
		} catch (Exception e) {

			log.error("TODO追加でエラー", e);
		}

		return "redirect:/";
	}
	
	//例外処理
	@ExceptionHandler(Exception.class)
	@GetMapping("/adds")
	public String dataAccessExceptionHondler(Exception e, Model model) {

		model.addAttribute("message", "ありがとう");
		
		return "todo/error";
		
	}
	

	// 詳細画面の表示
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

	// 削除
	@PostMapping(value = "/", params = "delete")
	public String deleteTodo(TodoDetailForm form, Model model) {

		todoService.deteleTodos(form.getId());

		return "redirect:/";
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