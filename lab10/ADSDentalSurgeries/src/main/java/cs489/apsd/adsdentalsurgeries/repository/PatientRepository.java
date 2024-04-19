package cs489.apsd.adsdentalsurgeries.repository;

import cs489.apsd.adsdentalsurgeries.dto.PatientRecord;
import cs489.apsd.adsdentalsurgeries.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public Patient findPatientByFullNameIsStartingWith(String name);
    List<Patient> findAllByAddressCity(String city);
}
