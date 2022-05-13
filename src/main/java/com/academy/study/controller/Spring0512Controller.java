package com.academy.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.academy.study.domain.Spring0512Dto;
import com.academy.study.service.Spring0512Service;

@Controller
@RequestMapping("study")
public class Spring0512Controller {
	
	@Autowired
	private Spring0512Service service;
	
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

	

}
