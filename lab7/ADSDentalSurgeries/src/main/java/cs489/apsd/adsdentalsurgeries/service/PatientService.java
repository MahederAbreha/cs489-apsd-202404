package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.dto.PatientRecord;
import cs489.apsd.adsdentalsurgeries.model.Patient;

import java.util.List;

public interface PatientService {
    PatientRecord addNewPatient(PatientRecord patientRecord);
    PatientRecord updatePatient(Integer patientId,PatientRecord editedPatient);
    void deletePatient(Integer patientId);
    PatientRecord getPatientById(Integer patientId);
    List<PatientRecord> getAllPatients();
    Patient getPatientEntityById(Integer patientId);
    PatientRecord findPatientByFullNameIsStartingWith(String name);

    List<PatientRecord> findAllByAddressCity(String city);
}
