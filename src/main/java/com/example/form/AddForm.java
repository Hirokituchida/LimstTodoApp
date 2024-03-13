package com.example.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AddForm {
	private String id;
	
	@NotBlank
	private String title;
	private boolean Done;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timeLimit;


}
