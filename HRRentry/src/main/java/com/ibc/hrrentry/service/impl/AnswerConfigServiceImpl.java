package com.ibc.hrrentry.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibc.hrrentry.dto.AnswerDTO;
import com.ibc.hrrentry.entity.Answer;
import com.ibc.hrrentry.entity.Question;
import com.ibc.hrrentry.repository.AnswerServiceConfigRepository;
import com.ibc.hrrentry.service.AnswerConfigService;
import com.ibc.hrrentry.utils.SurveyUtils;

@Component
public class AnswerConfigServiceImpl implements AnswerConfigService {

	@Autowired
	public AnswerServiceConfigRepository repository;
	
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	SurveyUtils util;
	
	@Override
	public Iterable<AnswerDTO> getAllAnswers() {
		List<AnswerDTO> answerList = new ArrayList<AnswerDTO>();
		for (Answer answer : repository.findAll()) {
			answerList.add(convertToDto(answer));
		}
		Collections.sort(answerList);
		return answerList;
	}

	@Override
	public void createAnswer(AnswerDTO answer) {
		Answer ans=(Answer)util.addAuditDetails(convertToEntity(answer));

		ans.setQuestion(util.findQuestionId(answer.getQuestion_id()));
		
		repository.save(ans);

	}

	/*
	 * private Answer addSurveyDetails(Answer survey) { Date date=new Date();
	 * survey.setDate_created(date); survey.setCreated_by(""); return survey; }
	 */
	private void updateSurveyDetails(AnswerDTO answer) {
		
		Optional<Answer> answerlist = repository.findById(answer.getId());
		Date date = new Date();
		answerlist.ifPresent(p -> {
			p.setDate_updated(date);

			if (answer.getDescription() != null) {
				p.setDescription(answer.getAnswer());
			}
			if (answer.getAnswer() != null) {
				p.setAnswer(answer.getAnswer());
			}
			repository.save(p);
		});
	}
	@Override
	public void updateAnswer(AnswerDTO survey) {
		//updateSurveyDetails(convertToEntity(survey));
	updateSurveyDetails(survey);
	}

	@Override
	public void deleteAnswer(long id) {
		repository.deleteById(id);

	}
	private AnswerDTO convertToDto(Answer post) {
		AnswerDTO AnswerDTO = modelMapper.map(post, AnswerDTO.class);
		
		return AnswerDTO;
	}

	private Answer convertToEntity(AnswerDTO AnswerDTO)  {
		Answer post = modelMapper.map(AnswerDTO, Answer.class);
		
		return post;
	}
}

