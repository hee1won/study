package com.academy.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.academy.study.domain.Spring0512ReplyDto;
import com.academy.study.service.Spring0512ReplyService;

@Controller
@RequestMapping("study")
public class Spring0512Reply {
	
	@Autowired
	private Spring0512ReplyService service;
	
	@PostMapping("reply")
	public String addReply(Spring0512ReplyDto reply) {
		boolean success = service.addReply(reply);
		
		return "redirect:/study/studyBoard/" + reply.getBoardId();
	}
	
	@PostMapping("ReplyRemove")
	public String removeReply(Spring0512ReplyDto reply) {
		boolean scueess = service.removeReply(reply.getId());
		
		return "redirect:/study/studyBoard/" + reply.getBoardId();
	}
	
	@PostMapping("replyModify")
	public String modifyReply(Spring0512ReplyDto reply) {
		boolean success = service.modifyReply(reply);
		
		return "redirect:/study/studyBoard/" + reply.getBoardId();
	}

}
