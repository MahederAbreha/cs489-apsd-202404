package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.model.Surgery;

import java.util.List;

public interface SurgeryService {
    Surgery addNewSurgery(Surgery surgery);
    Surgery updateSurgery(Integer surgeryId, Surgery editedSurgery);
    void deleteSurgery(Integer surgeryId);
    Surgery getSurgeryById(Integer surgeryId);
}
