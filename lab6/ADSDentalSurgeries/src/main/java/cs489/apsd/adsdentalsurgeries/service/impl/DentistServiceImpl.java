package cs489.apsd.adsdentalsurgeries.service.impl;

import cs489.apsd.adsdentalsurgeries.model.Dentist;
import cs489.apsd.adsdentalsurgeries.repository.DentistRepository;
import cs489.apsd.adsdentalsurgeries.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Dentist updateDentist(Integer dentistId, Dentist editedDentist) {
        var dentistToUpdate = dentistRepository.findById(dentistId).get();
        dentistToUpdate.setFullName(editedDentist.getFullName());
        dentistToUpdate.setPhoneNumber(editedDentist.getPhoneNumber());
        dentistToUpdate.setEmail(editedDentist.getEmail());
        dentistToUpdate.setSpeciality(editedDentist.getSpeciality());
        return dentistRepository.save(dentistToUpdate);
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
        return dentist.orElse(null);
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }
}
