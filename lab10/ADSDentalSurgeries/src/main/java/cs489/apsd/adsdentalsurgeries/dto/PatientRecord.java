package cs489.apsd.adsdentalsurgeries.dto;

import cs489.apsd.adsdentalsurgeries.model.Address;
import cs489.apsd.adsdentalsurgeries.model.Role;

import java.time.LocalDate;
import java.util.List;

public record PatientRecord(
        String fullName,
        String phoneNumber,
        String email,
        List<Role> role,
        LocalDate dateOfBirth,
        Address address ) {

}
