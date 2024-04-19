package cs489.apsd.adsdentalsurgeries;

import cs489.apsd.adsdentalsurgeries.dto.PatientRecord;
import cs489.apsd.adsdentalsurgeries.exception.PatientNotFoundException;
import cs489.apsd.adsdentalsurgeries.model.Address;
import cs489.apsd.adsdentalsurgeries.model.Patient;
import cs489.apsd.adsdentalsurgeries.model.Role;
import cs489.apsd.adsdentalsurgeries.model.RoleType;
import cs489.apsd.adsdentalsurgeries.repository.PatientRepository;
import cs489.apsd.adsdentalsurgeries.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PatientServiceTest {
    @MockBean
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPatientById() {
        PatientRecord patientRecord = new PatientRecord( "John Doe", "6012310098",
                "john.doe@gmail.com ",  List.of(new Role(1L, RoleType.DENTIST)), LocalDate.of(1996, 1, 1),
                new Address(1, "123 N St.", "Fairfield", "IA", "52556" )) ;
        Patient patient = new Patient(LocalDate.of(1996, 1, 1), new Address(1, "123 N St.", "Fairfield", "IA", "52556"), null);
        patient.setUserId(1);
        patient.setFullName("John Doe");
        patient.setEmail("john.doe@gmail.com");
        patient.setPhoneNumber("6012310098");
        patient.setRole(List.of(new Role(11, RoleType.DENTIST, null)));
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
        var patientRes = patientService.getPatientById(1);
        assertEquals(patientRecord, patientRes);
        verify(patientRepository).findById(1);
    }

    @Test
    public void testFindPatientByIdInvalid() {
        when(patientRepository.findById(1)).thenThrow(new PatientNotFoundException("Patient not found"));
        assertThrows(PatientNotFoundException.class, () -> {
            patientService.getPatientEntityById(1);
        });
    }
}
