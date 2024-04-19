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

    public AdsDentalSurgeriesApplication(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public static void main(String[] args) {
		SpringApplication.run(AdsDentalSurgeriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
