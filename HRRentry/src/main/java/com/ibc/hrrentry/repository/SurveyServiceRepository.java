package com.ibc.hrrentry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibc.hrrentry.entity.Survey;
import com.ibc.hrrentry.entity.Survey_Result;

@Repository
public interface SurveyServiceRepository extends CrudRepository<Survey_Result, Long> {

	
	@Query(value="select * from SUY_RSL where user_id=:username ORDER BY SUY_TS DESC", nativeQuery=true)
    List<Survey_Result> getSurveyTemplate(String username);
    
    @Query(value="update Survey_Result set survey_result=:result where user_id=:username", nativeQuery=true)
    List<Survey_Result> saveSurvey(String result,String username);
}
