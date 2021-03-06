package com.academy.study.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Spring0512ReplyDto {
	
	private int id;
	private int boardId; // board_id column과 매칭, 별칭(alias) 잘 쓸 것
	private String content;
	private LocalDateTime inserted;

}
