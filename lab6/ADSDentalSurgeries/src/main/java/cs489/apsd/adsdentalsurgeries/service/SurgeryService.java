package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.model.Surgery;

public interface SurgeryService {
    Surgery addNewSurgery(Surgery surgery);
    Surgery updateSurgery(Surgery editedSurgery);
    void deleteSurgery(Integer surgeryId);
    Surgery getSurgeryById(Integer surgeryId);
    Surgery getSurgery(Surgery surgery);
}
