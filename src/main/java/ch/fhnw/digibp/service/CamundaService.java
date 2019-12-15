package ch.fhnw.digibp.service;

import ch.fhnw.digibp.model.Patient;
import ch.fhnw.digibp.model.SurveyModel;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CamundaService {

    private RuntimeService runtimeService;

    @Autowired
    public CamundaService(RuntimeService runtimeService){
        this.runtimeService = runtimeService;
    }

    public String createPatient(Patient patient){
        Map<String, Object> processVars = new HashMap<>();
        processVars.put("age", patient.getAge());
        processVars.put("uuid", patient.getUuid());
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("registerationProcess", processVars);
        return processInstance.getId();
    }

    public String createSurvey(SurveyModel surveyModel){
        Map<String, Object> processVars = new HashMap<>();
        processVars.put("uuid", surveyModel.getUuid());
        processVars.put("survey_uuid", surveyModel.getSurvey_uuid());
        processVars.put("survey_score", surveyModel.getScore());
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Clinical_Trial_Survey_Validation", processVars);
        return processInstance.getId();
    }
}
