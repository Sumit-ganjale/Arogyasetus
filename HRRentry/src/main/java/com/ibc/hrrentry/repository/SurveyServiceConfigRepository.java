package com.ibc.hrrentry.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibc.hrrentry.entity.Survey;

@Repository
public interface SurveyServiceConfigRepository extends CrudRepository<Survey, Long> {
	
	@Modifying
@Transactional
	@Query(value="update SVY s set s.STS_ACTV_IND=:status where s.SVY_SK = :id", nativeQuery=true)
    void deleteSurvey(long id,String status);
	
	
}
