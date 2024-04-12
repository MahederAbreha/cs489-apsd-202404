package cs489.apsd.adsdentalsurgeries.service.impl;

import cs489.apsd.adsdentalsurgeries.model.Dentist;
import cs489.apsd.adsdentalsurgeries.repository.DentistRepository;
import cs489.apsd.adsdentalsurgeries.service.DentistService;
import org.springframework.stereotype.Service;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }


    @Override
    public Dentist addNewDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist updateDentist(Dentist editedDentist) {
        var dentist = dentistRepository.findById(editedDentist.getUserId());
        if (dentist.isEmpty()) {
            return null;
        } else {
            return dentistRepository.save(editedDentist);
        }
    }

    @Override
    public void deleteDentist(Integer dentistId) {
        var dentist = dentistRepository.findById(dentistId);
        if (dentist.isPresent()) {
            dentistRepository.delete(dentist.get());
        } else {
            throw new RuntimeException("Dentist not found");
        }

    }

    @Override
    public Dentist getDentistById(Integer dentistId) {
        var dentist = dentistRepository.findById(dentistId);
        if (dentist.isPresent()) {
            return dentist.get();
        } else {
            return null;
        }
    }
}
