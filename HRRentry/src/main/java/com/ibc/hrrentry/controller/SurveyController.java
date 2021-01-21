package com.ibc.hrrentry.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.ibc.hrrentry.entity.Survey;
import com.ibc.hrrentry.entity.Survey_Result;
import com.ibc.hrrentry.service.SurveyService;

@RestController
public class SurveyController {

	
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
	SurveyService service;
	
	@GetMapping(value = "/surveyform")

	public ResponseEntity allsurvey(@RequestParam("username") String username) {
		Survey survey =service.getSurvey(username);
		
		try {
				return new ResponseEntity(survey, HttpStatus.OK);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error,please contact system administrator");
		}
	}

	@PutMapping(value = "/savesurvey​")

	public ResponseEntity saveSurvey​(@RequestParam("username") String username,Survey survey) {

		try {
			service.saveSurvey(username,survey);
			return ResponseEntity.status(HttpStatus.CREATED).body("Survey Created successfully");
		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

//	@PatchMapping(value = "/updatesurvey")
//
//	public ResponseEntity updateSurvey(Survey survey) {
//		try {
//			service.updateSurvey(survey);
//			return ResponseEntity.status(HttpStatus.CREATED).body(("Survey updated successfully"));
//
//		} catch (BadRequest e) {
//			// List<Errors> message = createMessage(e.getCause());
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("Server encountered internal error please contact system administator");
//		}
//	}
//
//	@DeleteMapping(value = "/deletesurvey")
//
//	public ResponseEntity deleteSurvey(Survey survey) {
//		try {
//			service.deleteSurvey(survey);
//			return ResponseEntity.status(HttpStatus.OK).body("Survey Deleted Successfully");
//
//		} catch (BadRequest e) {
//			// List<Errors> message = createMessage(e.getCause());
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("Server encountered internal error please contact system administator");
//		}
//	}

}

/*
 * private Messages addMessages(String string) {
 * 
 * Messages message = new Messages(); message.setMessage("Success");
 * message.setDescription(string); return message;
 * 
 * } /* private List<Errors> createMessage(Set<ConstraintViolation<?>> set) {
 * List<Errors> list = new ArrayList<Errors>(); for (ConstraintViolation
 * violation : set) { Errors error = new Errors(); String attribute =
 * violation.getPropertyPath().toString(); StringBuilder stringBuilder = new
 * StringBuilder(); stringBuilder.append("Error parsing Attribute :");
 * 
 * stringBuilder.append(attribute); stringBuilder.append(",");
 * stringBuilder.append(" "); stringBuilder.append("reason : ");
 * stringBuilder.append(violation.getMessage());
 * error.setMessage(stringBuilder.toString()); error.setStatusCode(400);
 * list.add(error); } return list;
 * 
 * }
 */
