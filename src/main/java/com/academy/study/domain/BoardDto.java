package com.academy.study.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private int id;
	private String title;
	private String body;
	private LocalDateTime inserted;
	
	private int numOfReply;
}
