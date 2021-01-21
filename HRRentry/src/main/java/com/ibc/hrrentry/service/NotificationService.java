package com.ibc.hrrentry.service;

import com.ibc.hrrentry.dto.NotificationDTO;

public interface NotificationService {
	
	public Iterable<NotificationDTO> allNotifications();
	public void createNotification(NotificationDTO survey);
	public void updateNotification(NotificationDTO survey);
	public void deleteNotification(long id);
	public NotificationDTO findNotification(String type);
}
