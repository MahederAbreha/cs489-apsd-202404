package cs489.apsd.adsdentalsurgeries.repository;

import cs489.apsd.adsdentalsurgeries.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
