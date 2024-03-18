package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

		if(bindingResult.hasErrors()) {
			return getAdd(model,locale,form);
		}
		
		Todo todo = modelMapper.map(form, Todo.class);

		try {

			todoService.getAdditionTodos(todo);
		} catch (DuplicateKeyException e) {

			model.addAttribute("message", "タイトルが重複しています");
			return getAdd(model,locale,form);
		}

		return "redirect:/";
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
	
	@PostMapping(value = "/todo/detail", params = "update")
	public String todoUpdate(@ModelAttribute TodoDetailForm form, Model model) {

		todoService.todoUpdate(form.getId(), form.getTitle(), form.getTimeLimit());

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