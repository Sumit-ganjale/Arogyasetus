package com.ibc.hrrentry.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibc.hrrentry.entity.Answer;

@Repository
public interface AnswerServiceConfigRepository extends CrudRepository<Answer, Long> {
	
	
	

}
