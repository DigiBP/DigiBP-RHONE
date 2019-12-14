package ch.fhnw.digibp.service;

import ch.fhnw.digibp.model.Patient;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Service
public class CamundaService {

    private RuntimeService runtimeService;

    public CamundaService(RuntimeService runtimeService){
        this.runtimeService = runtimeService;
    }

    public String createPatient(Patient patient){
        Map<String, Object> processVars = new HashMap<>();
        processVars.put("age", patient.getAge());
        processVars.put("uuid", patient.getAge());
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("registerationProcess", processVars);
        return processInstance.getId();
    }
}
