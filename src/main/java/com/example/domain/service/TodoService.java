package com.example.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.model.Todo;
import com.example.repository.TodoMapper;

@Service
public interface TodoService {
	public List<Todo> getTodos();
//	//@Autowired 
//	//private TodoMapper todoMapper;
//
//    //public List<Todo> getAllTodos() {
//        //return todoMapper.findMany();
//    }
    public TodoMapper findOne(String id);
	Todo getUserOne(String id);
	public List<Todo> getIncompleteTodos();
	public List<Todo> getCompletedTodos();

}
