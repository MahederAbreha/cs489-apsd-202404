package cs489.apsd.adsdentalsurgeries.controller;

import cs489.apsd.adsdentalsurgeries.dto.PatientRecord;
import cs489.apsd.adsdentalsurgeries.model.Patient;
import cs489.apsd.adsdentalsurgeries.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/list")
    public List<PatientRecord> listPatients() {
        return patientService.getAllPatients();

    }
    @PostMapping("/")
    public ResponseEntity<PatientRecord> addPatient(@RequestBody PatientRecord patientRecord) {
        return ResponseEntity.ok(patientService.addNewPatient(patientRecord));
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Integer id) {
        return patientService.getPatientEntityById(id);
    }

    @PutMapping("/update/{id}")
    public PatientRecord updatePatient(@PathVariable Integer id, @RequestBody PatientRecord patientRecord) {
        return patientService.updatePatient(id, patientRecord);
    }

    @GetMapping("/search/{name}")
    public PatientRecord searchPatient(@PathVariable String name) {
        return patientService.findPatientByFullNameIsStartingWith(name);
    }

    @GetMapping("/address/{city}")
    public List<PatientRecord> searchPatientByCity(@PathVariable String city) {
        return patientService.findAllByAddressCity(city);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }
}
