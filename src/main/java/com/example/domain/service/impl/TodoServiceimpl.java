package com.example.domain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Override
	public void getAdditionTodos(Todo todo) {
		mapper.getAdditionTodos(todo);
	}
	
	@Override
    public Todo getTodoDetail(int id) {
		return mapper.getTodoDateil(id);
	}
	
	@Override
	public void deteleTodos(String id) {
		mapper.deteleTodos(id);
	}
	
	@Override
	public void todoUpdate(String id, String title,Date timeLimit) {
		mapper.todoUpdate(id,title,timeLimit);
	}

	
}
