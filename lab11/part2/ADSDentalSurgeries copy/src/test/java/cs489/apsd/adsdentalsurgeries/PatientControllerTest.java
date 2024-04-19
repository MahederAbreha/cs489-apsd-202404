package cs489.apsd.adsdentalsurgeries;

import cs489.apsd.adsdentalsurgeries.controller.PatientController;
import cs489.apsd.adsdentalsurgeries.dto.PatientRecord;
import cs489.apsd.adsdentalsurgeries.model.Address;
import cs489.apsd.adsdentalsurgeries.model.Role;
import cs489.apsd.adsdentalsurgeries.model.RoleType;
import cs489.apsd.adsdentalsurgeries.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {
    @MockBean
    private PatientService patientService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testRegisterPatient() throws Exception {
        PatientRecord patientRecord = new PatientRecord( "John Doe", "6012310098",
                "john.doe@gmail.com ",  List.of(new Role(1L, RoleType.DENTIST)), LocalDate.of(1996, 1, 1),
                new Address(1, "123 N St.", "Fairfield", "IA", "52556" )) ;
        Mockito.when(patientService.getAllPatients()).thenReturn(List.of(patientRecord));
        mockMvc.perform(get("/patients/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("john.doe@gmail.com"));
    }
}
