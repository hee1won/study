package com.academy.study.mapper;

import java.util.List;

import com.academy.study.domain.Spring0512ReplyDto;

public interface Spring0512ReplyMapper {

	int insertReply(Spring0512ReplyDto reply);

	List<Spring0512ReplyDto> selectReplyStudy(int boardId);

	int deleteReply(int id);

	int modifyReply(Spring0512ReplyDto reply);

	void deleteReplyByBody(int boardId);

}
