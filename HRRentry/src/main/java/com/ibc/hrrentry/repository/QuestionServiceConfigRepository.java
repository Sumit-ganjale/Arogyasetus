package com.ibc.hrrentry.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibc.hrrentry.entity.Question;
import com.ibc.hrrentry.entity.Survey;

@Repository
public interface QuestionServiceConfigRepository extends CrudRepository<Question, Long> {
	
	
	
	
	
	
}
