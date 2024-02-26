package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.model.Todo;

@Mapper
public interface TodoMapper {
	
    public List<Todo> getFalseTodos();
    
    public List<Todo> getTrueTodos();
    
    public int getAdditionTodos(Todo todo);

}
