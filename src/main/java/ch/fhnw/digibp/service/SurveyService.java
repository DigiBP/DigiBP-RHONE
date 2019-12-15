package ch.fhnw.digibp.service;

import ch.fhnw.digibp.model.SurveyModel;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    private CamundaService camundaService;

    public SurveyService(CamundaService camundaService){
        this.camundaService = camundaService;
    }

    public String createSurvey(SurveyModel surveyModel){
        return this.camundaService.createSurvey(surveyModel);
    }
}
