package com.academy.study.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.study.domain.BoardDto;
import com.academy.study.domain.Spring0512Dto;
import com.academy.study.mapper.Spring0512Mapper;
import com.academy.study.mapper.Spring0512ReplyMapper;

@Service
public class Spring0512Service {
	
	@Autowired
	private Spring0512Mapper mapper;
	
	@Autowired
	private Spring0512ReplyMapper replyMapper;

	public String getStudyCustomerName(int id) {
		
		return mapper.StudyCustomerNameById(id);
	}

	public String getStudyFirstName(int id) {
		
		return mapper.StudyEmployeeFirstNmaeById(id);
		
	}

	public List<Spring0512Dto> getStudyBoard() {
		
		return mapper.selectboard();
	}

	public Spring0512Dto getBodyStudy(int id) {
		return mapper.selectbody(id);
	}

	public boolean updateStudy(BoardDto board) {
		
		int cnt = mapper.updateBoard(board);
		
		return cnt==1;
	}
	
	@Transactional
	public boolean removeBodyById(int id) {
		
		// 댓글 먼저 지우기 
		replyMapper.deleteReplyByBody(id);
		
		// exception transaction
		
		// 그 다음 게시글 지우기
		int cnt = mapper.deleteBody(id);
		return cnt==1;
	}

	public boolean addBoard(BoardDto board) {
		board.setInserted(LocalDateTime.now());
		
		int cnt = mapper.insertBoard(board);
		
		return cnt==1;
	}

}
