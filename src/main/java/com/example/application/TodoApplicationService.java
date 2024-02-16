package com.example.application;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TodoApplicationService {
	
	public Map<String,Integer> getbtnMap() {
		 Map<String,Integer> btnMap = new LinkedHashMap<>();
		 btnMap.put("詳細", 1);
		 btnMap.put("削除", 2);
		 return btnMap;
	}

}
