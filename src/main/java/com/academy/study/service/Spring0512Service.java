package com.academy.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.academy.study.domain.Spring0512Dto;
import com.academy.study.mapper.Spring0512Mapper;

@Service
public class Spring0512Service {
	
	@Autowired
	private Spring0512Mapper mapper;

	public String getStudyCustomerName(int id) {
		
		return mapper.StudyCustomerNameById(id);
	}

	public String getStudyFirstName(int id) {
		
		return mapper.StudyEmployeeFirstNmaeById(id);
		
	}

	public List<Spring0512Dto> getStudyBoard() {
		
		return mapper.selectboard();
	}

}
