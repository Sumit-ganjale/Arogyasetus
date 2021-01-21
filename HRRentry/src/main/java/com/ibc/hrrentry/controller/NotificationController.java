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

import com.ibc.hrrentry.dto.NotificationDTO;
import com.ibc.hrrentry.entity.Messages;
import com.ibc.hrrentry.service.NotificationService;

@RestController
public class NotificationController {


	@Autowired
	NotificationService service;

	
	@GetMapping(value = "/allnotification")

	public ResponseEntity allNotifications() {

		List<NotificationDTO> surveyList = (List<NotificationDTO>) service.allNotifications();

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

	@PostMapping(value = "/createnotification")

	public ResponseEntity createNotification(@RequestBody NotificationDTO survey) {

		try {
			service.createNotification(survey);
			return ResponseEntity.status(HttpStatus.CREATED).body(addMessages("Notification Created successfully",201));
		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@PatchMapping(value = "/updatenotification")

	public ResponseEntity updateNotification(@RequestBody NotificationDTO patch) {
		try {

			service.updateNotification(patch);
			return ResponseEntity.status(HttpStatus.CREATED).body(("Notification updated successfully"));

		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@DeleteMapping(value = "/deletenotification/{id}")

	public ResponseEntity deleteNotification(@PathVariable long id) {
		try {
			service.deleteNotification(id);
			return ResponseEntity.status(HttpStatus.OK).body("Notification Deleted Successfully");

		} catch (BadRequest e) {
			// List<Errors> message = createMessage(e.getCause());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error please contact system administator");
		}
	}

	@GetMapping(value = "/findnotification")

	public ResponseEntity findNotification(@RequestParam("notificationType") String notificationType) {

		NotificationDTO notificationDto =  service.findNotification(notificationType);

		try {
			if(notificationDto!=null)
				return new ResponseEntity(notificationDto, HttpStatus.OK);
			else
				return new ResponseEntity(addMessages(("No Survey Found"),200), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Server encountered internal error,please contact system administrator");
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
