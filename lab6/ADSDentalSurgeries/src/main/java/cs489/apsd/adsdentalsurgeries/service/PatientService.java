package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.model.Patient;

public interface PatientService {
    Patient addNewPatient(Patient patient);
    Patient updatePatient(Patient editedPatient);
    void deletePatient(Integer patientId);
    Patient getPatientById(Integer patientId);
    Patient getPatientByUserId(Integer userId);
}
