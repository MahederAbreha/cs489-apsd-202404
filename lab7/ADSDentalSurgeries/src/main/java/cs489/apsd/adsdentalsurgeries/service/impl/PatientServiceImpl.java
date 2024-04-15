package cs489.apsd.adsdentalsurgeries.service.impl;

import cs489.apsd.adsdentalsurgeries.dto.AddressRecord;
import cs489.apsd.adsdentalsurgeries.dto.PatientRecord;
import cs489.apsd.adsdentalsurgeries.model.Address;
import cs489.apsd.adsdentalsurgeries.model.Patient;
import cs489.apsd.adsdentalsurgeries.repository.PatientRepository;
import cs489.apsd.adsdentalsurgeries.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public PatientRecord addNewPatient(PatientRecord patientRecord) {
        Patient patient = new Patient();
        patient.setFullName(patientRecord.fullName());
        patient.setPhoneNumber(patientRecord.phoneNumber());
        patient.setEmail(patientRecord.email());
        patient.setRole(patientRecord.role());
        patient.setDateOfBirth(patientRecord.dateOfBirth());
        patient.setAddress(patientRecord.address());

        Patient savedPatient = patientRepository.save(patient);

        return new PatientRecord(savedPatient.getFullName(), savedPatient.getPhoneNumber(), savedPatient.getEmail(),
                savedPatient.getRole(), savedPatient.getDateOfBirth(), savedPatient.getAddress());
    }

    @Override
    public PatientRecord updatePatient(Integer patientId, PatientRecord editedPatient) {
        Patient p = patientRepository.findById(patientId).orElse(null);
        if (p != null) {
            p.setFullName(editedPatient.fullName());
            p.setPhoneNumber(editedPatient.phoneNumber());
            p.setEmail(editedPatient.email());
            p.setRole(editedPatient.role());
            p.setDateOfBirth(editedPatient.dateOfBirth());
            p.setAddress(new Address(editedPatient.address().getAddressId(), editedPatient.address().getStreet(), editedPatient.address().getCity(),
                    editedPatient.address().getState(), editedPatient.address().getZipCode()));
            patientRepository.save(p);
            return new PatientRecord(p.getFullName(), p.getPhoneNumber(), p.getEmail(), p.getRole(), p.getDateOfBirth(), p.getAddress());
        }
        return null;
    }

    @Override
    public void deletePatient(Integer patientId) {
        Patient p = patientRepository.findById(patientId).orElse(null);
        patientRepository.delete(p);

    }

    @Override
    public PatientRecord getPatientById(Integer patientId) {

        Patient p = patientRepository.findById(patientId).orElse(null);
        return new PatientRecord(p.getFullName(), p.getPhoneNumber(), p.getEmail(), p.getRole(), p.getDateOfBirth(), p.getAddress());
    }

    @Override
    public List<PatientRecord> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientRecord> patientRecords = new ArrayList<>();
        for (Patient p : patients) {
            PatientRecord patientRecord = new PatientRecord(p.getFullName(), p.getPhoneNumber(), p.getEmail(), p.getRole(), p.getDateOfBirth(), p.getAddress());
            patientRecords.add(patientRecord);
        }

        return patientRecords;
    }

    @Override
    public Patient getPatientEntityById(Integer patientId) {

        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public PatientRecord findPatientByFullNameIsStartingWith(String name) {
       Patient p = patientRepository.findPatientByFullNameIsStartingWith(name);
         return new PatientRecord(p.getFullName(), p.getPhoneNumber(), p.getEmail(), p.getRole(), p.getDateOfBirth(), p.getAddress());
    }

    @Override
    public List<PatientRecord> findAllByAddressCity(String city) {
        List<Patient> patients = patientRepository.findAllByAddressCity(city);
        List<PatientRecord> patientRecords = new ArrayList<>();
        for (Patient p : patients) {
            PatientRecord patientRecord = new PatientRecord(p.getFullName(), p.getPhoneNumber(), p.getEmail(), p.getRole(), p.getDateOfBirth(), p.getAddress());
            patientRecords.add(patientRecord);
        }

        return patientRecords;
    }


}