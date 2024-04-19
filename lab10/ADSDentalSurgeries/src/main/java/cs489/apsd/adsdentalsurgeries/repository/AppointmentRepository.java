package cs489.apsd.adsdentalsurgeries.repository;

import cs489.apsd.adsdentalsurgeries.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
