package com.ibc.hrrentry.service;

import com.ibc.hrrentry.dto.SurveyDTO;

public interface SurveyConfigService {
	
	public Iterable<SurveyDTO> getAllSurvey();
	public void createSurvey(SurveyDTO survey);
	public void updateSurvey(SurveyDTO survey);
	public void deleteSurvey(long id);
	public SurveyDTO findSurvey(long id);
}
