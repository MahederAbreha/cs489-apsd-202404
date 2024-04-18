package cs489.apsd.adsdentalsurgeries.repository;

import cs489.apsd.adsdentalsurgeries.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
