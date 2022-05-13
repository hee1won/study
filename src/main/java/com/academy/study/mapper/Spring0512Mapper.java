package com.academy.study.mapper;

import java.util.List;

import com.academy.study.domain.Spring0512Dto;

public interface Spring0512Mapper {

	String StudyCustomerNameById(int id);

	String StudyEmployeeFirstNmaeById(int id);

	List<Spring0512Dto> selectboard();

}
