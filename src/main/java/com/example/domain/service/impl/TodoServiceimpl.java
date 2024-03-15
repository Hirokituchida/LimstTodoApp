package com.example.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.Todo;
import com.example.domain.service.TodoService;
import com.example.repository.TodoMapper;

@Service
public class TodoServiceimpl implements TodoService {

	@Autowired
	private TodoMapper mapper;

	@Override
	public List<Todo> getFalseTodos() {
		return mapper.getFalseTodos();
	}
	
	@Override
	public List<Todo> getTrueTodos() {
		return mapper.getTrueTodos();
	}
	
//	@Override
//	public void getAddTodos(Todo todo) {
//		mapper.getAdditionTodos(todo);
//	}
	
	@Override
    public Todo getTodoDetail(int id) {
		return mapper.getTodoDateil(id);
	}
}
