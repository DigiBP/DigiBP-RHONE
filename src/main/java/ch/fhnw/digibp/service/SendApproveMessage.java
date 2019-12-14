package ch.fhnw.digibp.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spinjar.com.minidev.json.JSONObject;

import java.net.URI;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class SendApproveMessage implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        final String baseUrl = "https://www.pactd.ch/api/registration/approve";
        URI uri = new URI(baseUrl);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(delegateExecution.getVariable("uuid"));
        String JO = "{\"uuid\" : \"" + delegateExecution.getVariable("uuid") + "\"}";
        HttpEntity<String> request = new HttpEntity<>(JO, headers);
        restTemplate.postForEntity(uri, request, String.class);
    }
}