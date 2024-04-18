package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.model.Dentist;

import java.util.List;

public interface DentistService {
    Dentist addNewDentist(Dentist dentist);
    Dentist updateDentist(Integer dentistId, Dentist editedDentist);
    void deleteDentist(Integer dentistId);
    Dentist getDentistById(Integer dentistId);
    List<Dentist> getAllDentists();
}
