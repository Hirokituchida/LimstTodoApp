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
	public List<Todo> getTodos() {
		return mapper.findMany();
	}

//	@Override
//	public Todo getUserOne(String id) {
//		return mapper.findOne(id);}

	
}
