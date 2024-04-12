package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.model.Patient;

import java.util.List;

public interface PatientService {
    Patient addNewPatient(Patient patient);
    Patient updatePatient(Integer patientId,Patient editedPatient);
    void deletePatient(Integer patientId);
    Patient getPatientById(Integer patientId);
    List<Patient> getAllPatients();
}
