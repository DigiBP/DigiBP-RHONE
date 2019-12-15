package ch.fhnw.digibp.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class AcceptSurvey implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        final String baseUrl = "https://www.pactd.ch/api/survey/approve";
        URI uri = new URI(baseUrl);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String JO = "{\"uuid\" : \""+ delegateExecution.getVariable("uuid") +"\",\"survey_uuid\": \""
                + delegateExecution.getVariable("survey_uuid") + "\"}";
        HttpEntity<String> request = new HttpEntity<>(JO, headers);
        restTemplate.postForEntity(uri, request, String.class);
    }
}
