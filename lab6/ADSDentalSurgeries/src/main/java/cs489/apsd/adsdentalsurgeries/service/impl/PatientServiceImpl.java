package cs489.apsd.adsdentalsurgeries.service.impl;

import cs489.apsd.adsdentalsurgeries.model.Patient;
import cs489.apsd.adsdentalsurgeries.repository.PatientRepository;
import cs489.apsd.adsdentalsurgeries.service.PatientService;
import org.springframework.stereotype.Service;

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
    public Patient updatePatient(Patient editedPatient) {
        return null;
    }

    @Override
    public void deletePatient(Integer patientId) {

    }

    @Override
    public Patient getPatientById(Integer patientId) {
        return null;
    }

    @Override
    public Patient getPatientByUserId(Integer userId) {
        return null;
    }
}
