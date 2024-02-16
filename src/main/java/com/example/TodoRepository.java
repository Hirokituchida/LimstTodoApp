package com.example;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String,Object>findById(String id){
		
		String query="SELECT*"
		+"FROMemployee"
				+"WHEREid=?";
		//検索実行    
		Map<String, Object>employee = jdbcTemplate.queryForMap(query,id);

		return employee;
	}

}
