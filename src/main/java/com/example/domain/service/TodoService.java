package com.example.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.model.Todo;

@Service
public interface TodoService {
	
	public List<Todo> getTodos();
	
	public List<Todo> getTrueTodos();
}
