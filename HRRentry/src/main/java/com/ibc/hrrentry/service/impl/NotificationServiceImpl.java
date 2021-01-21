package com.ibc.hrrentry.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibc.hrrentry.dto.NotificationDTO;
import com.ibc.hrrentry.entity.Notification;
import com.ibc.hrrentry.entity.Survey;
import com.ibc.hrrentry.repository.NotificationServiceConfigRepository;
import com.ibc.hrrentry.repository.SurveyServiceConfigRepository;
import com.ibc.hrrentry.service.NotificationService;
import com.ibc.hrrentry.utils.SurveyUtils;

@Component
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	public NotificationServiceConfigRepository repository;
	
	@Autowired
	public SurveyServiceConfigRepository surveyServiceConfigRepository;
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	SurveyUtils util;
	
	@Override
	public Iterable<NotificationDTO> allNotifications() {
		List<NotificationDTO> notificationList = new ArrayList<NotificationDTO>();
		for (Notification notification : repository.findAll()) {
			notificationList.add(convertToDto(notification));
		}
		return notificationList;
	}
	
	@Override
	public void createNotification(NotificationDTO notificationDto) {
		
		Notification notification=(Notification)SurveyUtils.addAuditDetails(convertToEntity(notificationDto));
		notification.setSurvey(util.findSurveyById(notificationDto.getSurvey_id()));
		repository.save(notification);

	}

	

	

	private void updateDetails(NotificationDTO notificationDto) {
		Long id= new Long( notificationDto.getId());
		Optional<Notification> notification = repository.findById(id);
		Date date = new Date();
		notification.ifPresent(p -> {
			p.setDate_updated(date);
			p.setUpdated_by("");
			
			if (notificationDto.getNotification() != null) {
				p.setNotification(p.getNotification());
			}
			
			if (notificationDto.getNotificationType() != null) {
				p.setNotificationType(notificationDto.getNotificationType());
			}
			if (notificationDto.getStatus()!=null) {
				p.setStatus(notificationDto.getStatus());
			}
			if (notificationDto.getDelIndicator() != null) {
				p.setDelIndicator(notificationDto.getDelIndicator());
			}
			repository.save(p);
		});

	}
	
	@Override
	public void updateNotification(NotificationDTO notification) {
		updateDetails(notification);
	}

	@Override
	public void deleteNotification(long id) {
		repository.deleteSurvey(id,"N");

	}

	private NotificationDTO convertToDto(Notification post) {
		NotificationDTO NotificationDTO = modelMapper.map(post, NotificationDTO.class);

		return NotificationDTO;
	}

	private Notification convertToEntity(NotificationDTO NotificationDTO) {
		Notification post = modelMapper.map(NotificationDTO, Notification.class);

		return post;
	}

	@Override
	public NotificationDTO findNotification(String type) {
		return convertToDto(repository.findByType(type));
	}

	
	/*
	 * @Override public Optional<NotificationDTO> findSurvey(long id) {
	 * 
	 * repository.findById(id))
	 * 
	 * }
	 */
}
