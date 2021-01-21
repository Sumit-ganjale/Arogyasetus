package com.ibc.hrrentry.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibc.hrrentry.dto.QuestionDTO;
import com.ibc.hrrentry.dto.SurveyDTO;
import com.ibc.hrrentry.entity.Question;
import com.ibc.hrrentry.entity.Survey;
import com.ibc.hrrentry.repository.SurveyServiceConfigRepository;
import com.ibc.hrrentry.service.SurveyConfigService;

@Component
public class SurveyConfigServiceImpl implements SurveyConfigService {

	@Autowired
	public SurveyServiceConfigRepository repository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public Iterable<SurveyDTO> getAllSurvey() {
		List<SurveyDTO> surveyList = new ArrayList<SurveyDTO>();
		for (Survey survey : repository.findAll()) {
			surveyList.add(convertToDto(survey));
		}
		return surveyList;
	}
	
	@Override
	public void createSurvey(SurveyDTO survey) {
		// updateSurveyDetails(survey);
		repository.save(addSurveyDetails(convertToEntity(survey)));

	}

	private Survey addSurveyDetails(Survey survey) {
		Date date = new Date();
		survey.setDate_created(date);
		survey.setCreated_by("");

		return survey;
	}

	private void updateSurveyDetails(SurveyDTO surveyDto) {
		Long id= new Long( surveyDto.getId());
		Optional<Survey> survey = repository.findById(id);
		Date date = new Date();
		survey.ifPresent(p -> {
			p.setDate_updated(date);
			
			if (surveyDto.getDescription() != null) {
				p.setDescription(p.getDescription());
			}
			
			if (surveyDto.getName() != null) {
				p.setName(surveyDto.getName());
			}
			if (surveyDto.getFrequency() > 0) {
				p.setFrequency(surveyDto.getFrequency());
			}
			if (surveyDto.getNext_survey_date() != null) {
				p.setNext_survey_date(surveyDto.getNext_survey_date());
			}
			if (surveyDto.getStatus() != null) {
				p.setStatus(surveyDto.getStatus());
			}
			if (surveyDto.getQuestion() != null) {
				p.getQuestion().clear();
				p.setQuestion(convertToEntitySet(surveyDto.getQuestion()));
			}
			repository.save(p);
		});

	}
	private List<Question> convertToEntitySet(List<QuestionDTO> questionDtoSet) {
		List<Question> questionSet = new ArrayList<Question>();
		for (QuestionDTO questionDto : questionDtoSet) {
			questionSet.add(modelMapper.map(questionDto, Question.class));
		}
		Collections.sort(questionSet);
		return questionSet;

	}
	@Override
	public void updateSurvey(SurveyDTO survey) {
		updateSurveyDetails(survey);
	}

	@Override
	public void deleteSurvey(long id) {
		repository.deleteSurvey(id,"N");

	}

	private SurveyDTO convertToDto(Survey post) {
		SurveyDTO SurveyDTO = modelMapper.map(post, SurveyDTO.class);

		return SurveyDTO;
	}

	private Survey convertToEntity(SurveyDTO SurveyDTO) {
		Survey post = modelMapper.map(SurveyDTO, Survey.class);

		return post;
	}

	@Override
	public SurveyDTO findSurvey(long id) {
		Optional<Survey> surveyList=repository.findById(id);
		return convertToDto(surveyList.map(Stream::of).orElseGet(Stream::empty).findFirst().orElse(null));
	}

	
	/*
	 * @Override public Optional<SurveyDTO> findSurvey(long id) {
	 * 
	 * repository.findById(id))
	 * 
	 * }
	 */
}
