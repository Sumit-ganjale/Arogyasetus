package com.ibc.hrrentry.service;

import java.util.Optional;

import com.ibc.hrrentry.dto.QuestionDTO;
import com.ibc.hrrentry.entity.Question;

public interface QuestionConfigService {
	
	public Iterable<QuestionDTO> getAllQuestions();
	public void createQuestion(QuestionDTO survey);
	public void updateQuestion(QuestionDTO survey);
	public void deleteQuestion(long id);
	public Optional<Question> findQuestion(long id);
//	public QuestionDTO getQuestionFromDrools(QuestionDTO survey);

}
