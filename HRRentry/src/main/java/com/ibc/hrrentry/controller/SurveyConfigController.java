package com.ibc.hrrentry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.ibc.hrrentry.dto.AnswerDTO;
import com.ibc.hrrentry.dto.QuestionDTO;
import com.ibc.hrrentry.dto.SurveyDTO;
import com.ibc.hrrentry.entity.Messages;
import com.ibc.hrrentry.service.AnswerConfigService;
import com.ibc.hrrentry.service.QuestionConfigService;
import com.ibc.hrrentry.service.SurveyConfigService;

@RestController
public class SurveyConfigController {

	/*
	 * @PostMapping(value = "/registers")
	 * 
	 * public ResponseEntity<User> doRegister(User user) { String json = null;
	 * System.out.println(ResponseEntity.created(URI.create(String.format(
	 * "/persons/%s", user.getName()))).body(user)); return new ResponseEntity(user,
	 * HttpStatus.OK);
	 * 
	 * }
	 */

	@Autowired
	SurveyConfigService service;

	@Autowired
	QuestionConfigService questionService;

	@Autowired
	AnswerConfigService answerService;

	@GetMapping(value = "/allsurvey")

	public ResponseEntity allsurvey() {

		List<SurveyDTO> surveyList = (List<SurveyDTO>) service.getAllSurvey();

		try {
			if (surveyList != null && !surveyList.isEmpty())
				return new ResponseEntity(surveyList, HttpStatus.OK);
			else
				return new ResponseEntity(addMessages(("No Survey Found"),200), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error,please contact system administrator");
		}
	}

	@PostMapping(value = "/createsurvey")

	public ResponseEntity createSurvey(@RequestBody SurveyDTO survey) {

		try {
			service.createSurvey(survey);
			return ResponseEntity.status(HttpStatus.CREATED).body(addMessages("Survey Created successfully",201));
		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@PatchMapping(value = "/updatesurvey")

	public ResponseEntity updateSurvey(@RequestBody SurveyDTO patch) {
		try {

			service.updateSurvey(patch);
			return ResponseEntity.status(HttpStatus.CREATED).body(("Survey updated successfully"));

		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@DeleteMapping(value = "/deletesurvey/{id}")

	public ResponseEntity deleteSurvey(@PathVariable long id) {
		try {
			service.deleteSurvey(id);
			return ResponseEntity.status(HttpStatus.OK).body("Survey Deleted Successfully");

		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	
	@GetMapping(value = "/findsurvey")

	public ResponseEntity findsurvey(@RequestParam("id") long id) {

		SurveyDTO surveyDto =  service.findSurvey(id);

		try {
			if(surveyDto!=null)
				return new ResponseEntity(surveyDto, HttpStatus.OK);
			else
				return new ResponseEntity(addMessages(("No Survey Found"),200), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error,please contact system administrator");
		}
	}
	
	/* Question API */

	@GetMapping(value = "/allquestions")

	public ResponseEntity allQuestions() {

		List<QuestionDTO> questionsList = (List<QuestionDTO>) questionService.getAllQuestions();

		try {
			if (questionsList != null && !questionsList.isEmpty())
				return new ResponseEntity(questionsList, HttpStatus.OK);
			else
				return new ResponseEntity("No Questions Found", HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error,please contact system administrator");
		}
	}

	@PostMapping(value = "/createquestion")

	public ResponseEntity createQuestion(@RequestBody QuestionDTO question) {

		try {
			questionService.createQuestion(question);
			return ResponseEntity.status(HttpStatus.CREATED).body("Question Created successfully");
		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@PatchMapping(value = "/updatequestion")

	public ResponseEntity updateQuestion(@RequestBody QuestionDTO question) {
		try {
			questionService.updateQuestion(question);
			return ResponseEntity.status(HttpStatus.CREATED).body(("Question updated successfully"));

		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@DeleteMapping(value = "/deletequestion/{id}")

	public ResponseEntity deleteQuestion(@PathVariable long id) {
		try {
			questionService.deleteQuestion(id);

			return ResponseEntity.status(HttpStatus.OK).body("Question Deleted Successfully");

		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@GetMapping(value = "/allanswer")

	public ResponseEntity getallQuestions() {

		List<AnswerDTO> answerList = (List<AnswerDTO>) answerService.getAllAnswers();

		try {
			if (answerList != null && !answerList.isEmpty())
				return new ResponseEntity(answerList, HttpStatus.OK);
			else
				return new ResponseEntity("No Answer Found", HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error,please contact system administrator");
		}
	}

	@PostMapping(value = "/createanswer")

	public ResponseEntity createAnswer(@RequestBody AnswerDTO answer) {

		try {
			answerService.createAnswer(answer);
			return ResponseEntity.status(HttpStatus.CREATED).body("Answer Created successfully");
		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@PatchMapping(value = "/updateanswer")

	public ResponseEntity updateAnswer(@RequestBody AnswerDTO answer) {
		try {
			answerService.updateAnswer(answer);
			return ResponseEntity.status(HttpStatus.CREATED).body(("Answer updated successfully"));

		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@DeleteMapping(value = "/deleteanswer/{id}")

	public ResponseEntity deleteAnswer(@PathVariable long id) {
		try {
			answerService.deleteAnswer(id);
			return ResponseEntity.status(HttpStatus.OK).body("answer Deleted Successfully");

		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	private Messages addMessages(String string,int statusCode) {

		Messages message = new Messages();
		if(statusCode==201||statusCode==200) {
		message.setMessage("Success");
		}else {
			message.setMessage("Failure");
		}
		message.setDescription(string);
		return message;

	}
	
}

//	private List<Errors> createMessage(Set<ConstraintViolation<?>> set) 
//	{
//  List<Errors> list = new ArrayList<Errors>(); for (ConstraintViolation
// violation : set) { Errors error = new Errors(); String attribute =
//  violation.getPropertyPath().toString(); StringBuilder stringBuilder = new
// StringBuilder(); stringBuilder.append("Error parsing Attribute :");
//  
// stringBuilder.append(attribute); stringBuilder.append(",");
//  stringBuilder.append(" "); stringBuilder.append("reason : ");
//  stringBuilder.append(violation.getMessage());
//  error.setMessage(stringBuilder.toString()); error.setStatusCode(400);
//  list.add(error); } return list;
//  
//  }
