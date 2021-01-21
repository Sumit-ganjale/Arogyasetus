package com.ibc.hrrentry.service;

import com.ibc.hrrentry.dto.AnswerDTO;

public interface AnswerConfigService {
	
	public Iterable<AnswerDTO> getAllAnswers();
	public void createAnswer(AnswerDTO answer);
	public void updateAnswer(AnswerDTO answer);
	public void deleteAnswer(long id);

}
