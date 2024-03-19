package com.example.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDetailForm {
	private String id;
	
	@NotBlank
	@Length(min = 1, max = 40)
	@NotEmpty
	private String title;
	private boolean Done;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull
	private Date timeLimit;

}
