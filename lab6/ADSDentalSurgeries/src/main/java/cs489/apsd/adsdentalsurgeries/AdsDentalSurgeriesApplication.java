package cs489.apsd.adsdentalsurgeries;

import cs489.apsd.adsdentalsurgeries.model.*;
import cs489.apsd.adsdentalsurgeries.repository.RoleRepository;
import cs489.apsd.adsdentalsurgeries.service.AppointmentService;
import cs489.apsd.adsdentalsurgeries.service.DentistService;
import cs489.apsd.adsdentalsurgeries.service.PatientService;
import cs489.apsd.adsdentalsurgeries.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class AdsDentalSurgeriesApplication implements CommandLineRunner {
	private final RoleRepository roleRepository;
	private final UserService userService;
	private final PatientService patientService;
	private final DentistService dentistService;
	@Autowired
	private final AppointmentService appointmentService;

    public AdsDentalSurgeriesApplication(RoleRepository roleRepository, UserService userService, PatientService patientService,
										 DentistService dentistService, AppointmentService appointmentService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.appointmentService = appointmentService;
    }


    public static void main(String[] args) {
		SpringApplication.run(AdsDentalSurgeriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Medical Surgeries!");
		roleRepository.save(new Role(1, RoleType.OFFICE_MANAGER));
		roleRepository.save(new Role(2, RoleType.DENTIST));
		roleRepository.save(new Role(3, RoleType.PATIENT));


		var surgery1 = new Surgery(null, "Dental Clinic", "641-472-2345", new Address(null, "1000 Main St", "Fairfield", "Iowa", "52556"), List.of());
		var patient1 = new Patient(LocalDate.of(1990, 1, 1), null, null);
		var dentist1 = new Dentist("Orthodontist", null);
		var user = new User(null, "Office Manager", "641-222-3332", "manager@surgery1.com", roleRepository.findById(1).get());
		patient1.setFullName("John Doe");
		patient1.setPhoneNumber("641-345-9780");
		patient1.setEmail("jd@email.com");
		patient1.setRole(roleRepository.findById(3).get());

		dentist1.setFullName("Dr. Smith");
		dentist1.setPhoneNumber("641-123-3451");
		dentist1.setEmail("drsmith@email.com");
		dentist1.setRole(roleRepository.findById(2).get());
		var appointment1 = new Appointment(null, dentist1, patient1, surgery1, LocalDateTime.of(2021, 12, 1, 10, 30));


		appointmentService.addNewAppointment(appointment1);

	}

}
