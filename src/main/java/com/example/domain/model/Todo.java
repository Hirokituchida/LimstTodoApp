package com.example.domain.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Todo {
	private String id;
	private String title;
	private boolean Done;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date timeLimit;
}
