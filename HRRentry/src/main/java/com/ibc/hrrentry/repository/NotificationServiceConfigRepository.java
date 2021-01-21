package com.ibc.hrrentry.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibc.hrrentry.entity.Notification;

@Repository
public interface NotificationServiceConfigRepository extends CrudRepository<Notification, Long> {

	@Modifying
	@Transactional
	@Query(value="update SUY_NOTIFC s set s.DEL_IND=:status where s.SUY_NOTIFC_SK = :id", nativeQuery=true)
	void deleteSurvey(long id, String status);
	@Query(value="select * from SUY_NOTIFC s where s.NOTIFC_CHNLTP_ID = :type", nativeQuery=true)
	Notification findByType(String type);
	
	
	
	
	

}
