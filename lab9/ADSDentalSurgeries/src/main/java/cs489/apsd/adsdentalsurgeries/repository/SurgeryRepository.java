package cs489.apsd.adsdentalsurgeries.repository;

import cs489.apsd.adsdentalsurgeries.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
