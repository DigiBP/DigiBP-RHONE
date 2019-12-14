package ch.fhnw.digibp.service;

import ch.fhnw.digibp.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private CamundaService camundaService;

    PatientService(CamundaService camundaService){
        this.camundaService = camundaService;
    }

    public String createPatientInstance(Patient patient){
        return camundaService.createPatient(patient);
    }

}
