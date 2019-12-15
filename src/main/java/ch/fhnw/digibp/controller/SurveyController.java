package ch.fhnw.digibp.controller;

import ch.fhnw.digibp.model.SurveyModel;
import ch.fhnw.digibp.service.SurveyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService){
        this.surveyService = surveyService;
    }

    @PostMapping
    public String createSurvey(@RequestBody SurveyModel surveyModel){
        return this.surveyService.createSurvey(surveyModel);
    }
}
