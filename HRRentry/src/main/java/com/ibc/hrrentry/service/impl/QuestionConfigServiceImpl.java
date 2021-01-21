package com.ibc.hrrentry.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibc.hrrentry.dto.AnswerDTO;
import com.ibc.hrrentry.dto.QuestionDTO;
import com.ibc.hrrentry.entity.Answer;
import com.ibc.hrrentry.entity.Notification;
import com.ibc.hrrentry.entity.Question;
import com.ibc.hrrentry.entity.Survey;
import com.ibc.hrrentry.repository.QuestionServiceConfigRepository;
import com.ibc.hrrentry.service.QuestionConfigService;
import com.ibc.hrrentry.utils.SurveyUtils;

@Component
public class QuestionConfigServiceImpl implements QuestionConfigService {

	@Autowired
	public QuestionServiceConfigRepository repository;
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	SurveyUtils util;
	//@Autowired
	//private  KieContainer kieContainer;
	
	@Override
	public Iterable<QuestionDTO> getAllQuestions() {
		List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();
		for (Question question : repository.findAll()) {
			questionList.add(convertToDto(question));
		}
		Collections.sort(questionList);
		return questionList;
	}

	@Override
	public void createQuestion(QuestionDTO question) {
		Question ques=(Question)util.addAuditDetails(convertToEntity(question));

		ques.setSurvey(util.findSurveyById(question.getSurvey_id()));
		
		repository.save(ques);
		
	}



	

	private void updateSurveyDetails(QuestionDTO questionDto) {

		Optional<Question> survey = repository.findById(questionDto.getId());
		Date date = new Date();
		survey.ifPresent(p -> {
			p.setDate_updated(date);

			if (questionDto.getDescription() != null) {
				p.setDescription(questionDto.getQuestion());
			}
			if (questionDto.getQuestion() != null) {
				p.setQuestion(p.getDescription());
			}
			if (questionDto.getAnswer() != null) {
				p.getAnswer().clear();
				p.setAnswer(convertToEntitySet(questionDto.getAnswer()));
			}
			if (questionDto.getDisp_sequence() > 0) {
				p.setDisp_sequence(questionDto.getDisp_sequence());
			}
			if (questionDto.getQuestion_type() != null) {
				p.setQuestion_type(questionDto.getQuestion_type());
			}

			// if (surveyDto.getQuestion()!=null&&
			// surveyDto.getQuestion().isEmpty()){p.setQuestion(surveyDto.getQuestion());}
			repository.save(p);
		});

	}

	private QuestionDTO convertToDto(Question post) {
		QuestionDTO questionDTO = modelMapper.map(post, QuestionDTO.class);

		return questionDTO;
	}

	private Set<Answer> convertToEntitySet(Set<AnswerDTO> answerDtoSet) {
		Set<Answer> asnwerSet = new HashSet<Answer>();
		for (AnswerDTO answer : answerDtoSet) {
			asnwerSet.add(modelMapper.map(answer, Answer.class));
		}
		return asnwerSet;

	}

	private Question convertToEntity(QuestionDTO questionDTO) {
		Question post = modelMapper.map(questionDTO, Question.class);

		return post;
	}

	@Override
	public void updateQuestion(QuestionDTO question) {
		updateSurveyDetails(question);

	}
	@Override
	public Optional<Question> findQuestion(long id) {
		return  repository.findById(id);
	}
	@Override
	public void deleteQuestion(long id) {
		repository.deleteById(id);

	}

/*	@Override
	public QuestionDTO getQuestionFromDrools(QuestionDTO question) 
		{
			KieSession kieSession = kieContainer.newKieSession("rulesSession");
			kieSession.insert(question);
			kieSession.fireAllRules();
			kieSession.dispose();
			return question;
		
	}*/
}
