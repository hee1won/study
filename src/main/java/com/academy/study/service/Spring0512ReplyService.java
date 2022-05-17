package com.academy.study.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.study.domain.Spring0512ReplyDto;
import com.academy.study.mapper.Spring0512ReplyMapper;

@Service
public class Spring0512ReplyService {

	@Autowired
	private Spring0512ReplyMapper mapper;
	
	public boolean addReply(Spring0512ReplyDto reply) {
		reply.setInserted(LocalDateTime.now());
		int cnt = mapper.insertReply(reply);
		
		return cnt==1;
	}

	public List<Spring0512ReplyDto> listReplyStudy(int boardId) {
		
		
		return mapper.selectReplyStudy(boardId);
	}

	public boolean removeReply(int id) {
		int cnt = mapper.deleteReply(id);
		return cnt==1;
	}

	public boolean modifyReply(Spring0512ReplyDto reply) {
		
		int cnt = mapper.modifyReply(reply);
		return cnt==1;
	}

}
