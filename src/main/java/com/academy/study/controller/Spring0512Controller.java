package com.academy.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.academy.study.domain.BoardDto;
import com.academy.study.domain.Spring0512Dto;
import com.academy.study.domain.Spring0512ReplyDto;
import com.academy.study.service.Spring0512ReplyService;
import com.academy.study.service.Spring0512Service;

@Controller
@RequestMapping("study")
public class Spring0512Controller {

	@Autowired
	private Spring0512Service service;
	
	@Autowired
	private Spring0512ReplyService replyService;

	@RequestMapping("ssub01")
	public String study01(int id, Model studymodel) {

		String name = service.getStudyCustomerName(id);

		studymodel.addAttribute("customerName", name);

		return "/study/ssub01";

	}

	@RequestMapping("ssub02")

	public String study02(int id, Model studymodel) {

		String name = service.getStudyFirstName(id);

		studymodel.addAttribute("firstName", name);

		return "/study/ssub02";

	}

	// /study/studyBoard
	@GetMapping("studyBoard")

	public void study03(Model studyModel) {
		List<Spring0512Dto> studylist = service.getStudyBoard();

		studyModel.addAttribute("boardList", studylist);
	}

	@GetMapping("studyBoard/{id}")
	public String body01(@PathVariable("id") int id, Model model) {

		// 서비스일 시켜서 id에 해당하는 게시물 select

		Spring0512Dto dto = service.getBodyStudy(id);
		
		List<Spring0512ReplyDto> replyList = replyService.listReplyStudy(id);

		// 모델에 넣고

		model.addAttribute("bodyS", dto);
		model.addAttribute("replyList", replyList);

		// /WEB-INF/views/study/studyBoard.jsp로 포워드

		return "/study/studyBody";
	}

	@PostMapping("modify")
	public String modifyBoard(BoardDto board) {
		
		boolean success = service.updateStudy(board);
		
		if(success) {
		} else {
		}
		
		
		return "redirect:/study/studyBoard/"+board.getId();
	}
	
	@PostMapping("remove")
	public String removeBoard(int id) {
		boolean success = service.removeBodyById(id);
		
		if(success) {
			
		} else {
			
		}
		
		return "redirect:/study/studyBoard/";
	}
	
	@GetMapping("studyWrite")
	public void writeBoard() {
		
	}
	
	@PostMapping("studyWrite")
	public String writeBoardProcess(BoardDto board) {
		boolean success = service.addBoard(board);
		
		if(success) {
			
		} else {
			
		}
		
		
		return "redirect:/study/studyBoard/"+board.getId();
	}
}

