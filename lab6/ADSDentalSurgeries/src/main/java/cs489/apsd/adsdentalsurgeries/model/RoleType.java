package cs489.apsd.adsdentalsurgeries.model;

import lombok.Getter;

@Getter
public enum RoleType {
    PATIENT("Patient"),
    DENTIST("Dentist"),
    OFFICE_MANAGER("Office Manager");

    private final String roleType;

    RoleType(String roleType) {
        this.roleType = roleType;
    }

}
