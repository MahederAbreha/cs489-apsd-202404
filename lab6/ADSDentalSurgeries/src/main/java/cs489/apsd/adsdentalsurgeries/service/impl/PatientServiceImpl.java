package cs489.apsd.adsdentalsurgeries.service.impl;

import cs489.apsd.adsdentalsurgeries.model.Patient;
import cs489.apsd.adsdentalsurgeries.repository.PatientRepository;
import cs489.apsd.adsdentalsurgeries.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public Patient addNewPatient(Patient patient) {

        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Integer patientId, Patient editedPatient) {
        Patient patientToUpdate = patientRepository.findById(patientId).orElse(null);
        if (patientToUpdate != null) {
            patientToUpdate.setFullName(editedPatient.getFullName());
            patientToUpdate.setPhoneNumber(editedPatient.getPhoneNumber());
            patientToUpdate.setEmail(editedPatient.getEmail());
            patientToUpdate.setAddress(editedPatient.getAddress());
            return patientRepository.save(patientToUpdate);
        }
        return null;
    }


    @Override
    public void deletePatient(Integer patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient != null) {
            patientRepository.delete(patient);
        } else {
            throw new RuntimeException("Patient with the " + patientId + " id is not found");
        }

    }

    @Override
    public Patient getPatientById(Integer patientId) {
        return patientRepository.findById(patientId).orElse(null );
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


}
