package cs489.apsd.adsdentalsurgeries.service.impl;

import cs489.apsd.adsdentalsurgeries.model.Surgery;
import cs489.apsd.adsdentalsurgeries.repository.SurgeryRepository;
import cs489.apsd.adsdentalsurgeries.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    SurgeryRepository surgeryRepository;
    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }
    @Override
    public Surgery addNewSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public Surgery updateSurgery(Integer surgeryId, Surgery editedSurgery) {
        Surgery surgeryToUpdate = surgeryRepository.findById(surgeryId).orElse(null);
        if (surgeryToUpdate != null) {
            surgeryToUpdate.setName(editedSurgery.getName());
            surgeryToUpdate.setPhoneNumber(editedSurgery.getPhoneNumber());
            surgeryToUpdate.setAddress(editedSurgery.getAddress());
            return surgeryRepository.save(surgeryToUpdate);
        }
        return null;
    }


    @Override
    public void deleteSurgery(Integer surgeryId) {
        surgeryRepository.deleteById(surgeryId);

    }

    @Override
    public Surgery getSurgeryById(Integer surgeryId) {
        return surgeryRepository.findById(surgeryId).get();
    }

}
