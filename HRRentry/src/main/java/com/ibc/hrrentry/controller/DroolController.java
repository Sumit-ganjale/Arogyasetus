package com.ibc.hrrentry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ibc.hrrentry.dto.QuestionDTO;
import com.ibc.hrrentry.entity.Question;
import com.ibc.hrrentry.entity.User;
import com.ibc.hrrentry.service.QuestionConfigService;
@RestController
public class DroolController {

	private final QuestionConfigService questionConfigService;

	@Autowired
	public DroolController(QuestionConfigService questionConfigService) {
		this.questionConfigService = questionConfigService;
	}

	@GetMapping(value = "/getQuestions")
	public QuestionDTO getQuestions(@RequestParam(required = true) String type) {

		QuestionDTO question = new QuestionDTO();
		question.setQuestion(type);

	//	questionConfigService.getQuestionFromDrools(question);

		return question;
	}

}
	

