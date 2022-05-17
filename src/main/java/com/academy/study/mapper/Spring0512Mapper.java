package com.academy.study.mapper;

import java.util.List;

import com.academy.study.domain.BoardDto;
import com.academy.study.domain.Spring0512Dto;

public interface Spring0512Mapper {

	String StudyCustomerNameById(int id);

	String StudyEmployeeFirstNmaeById(int id);

	List<Spring0512Dto> selectboard();

	Spring0512Dto selectbody(int id);

	int updateBoard(BoardDto board);

	int deleteBody(int id);

	int insertBoard(BoardDto board);

}
