package cs489.apsd.adsdentalsurgeries.dto;

import cs489.apsd.adsdentalsurgeries.model.Address;
import cs489.apsd.adsdentalsurgeries.model.Role;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record PatientRecord(
        String fullName,
        String phoneNumber,
        String email,
        Set<Role> roles,
        LocalDate dateOfBirth,
        Address address ) {

}
