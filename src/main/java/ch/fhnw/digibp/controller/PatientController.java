package ch.fhnw.digibp.controller;

import ch.fhnw.digibp.model.Patient;
import ch.fhnw.digibp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping()
    public String createPatient(@RequestBody Patient patient){
        return patientService.createPatientInstance(patient);
    }

}
