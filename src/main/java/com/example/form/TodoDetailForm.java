package com.example.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDetailForm {
	private String id;
	private String title;
	private boolean Done;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timeLimit;

}
