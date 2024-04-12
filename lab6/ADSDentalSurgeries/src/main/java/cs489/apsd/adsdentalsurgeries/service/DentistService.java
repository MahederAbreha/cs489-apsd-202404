package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.model.Dentist;

public interface DentistService {
    Dentist addNewDentist(Dentist dentist);
    Dentist updateDentist(Dentist editedDentist);
    void deleteDentist(Integer dentistId);
    Dentist getDentistById(Integer dentistId);
//    Dentist getDentistByUserId(Integer userId);
}
