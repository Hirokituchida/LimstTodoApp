package com.example.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.model.Todo;

@Service
public interface TodoService {
	
	public List<Todo> getFalseTodos();
	
	public List<Todo> getTrueTodos();
	
	public void getAdditionTodos(Todo todo);
	
    public Todo getTodoDetail(int id);

	public void deteleTodos(String id);
	
	public void todoUpdate(String id, String title, Date timeLimit);


}
