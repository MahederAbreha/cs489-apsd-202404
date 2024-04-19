package cs489.apsd.adsdentalsurgeries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RoleId;
    private RoleType roleType;
    @ManyToMany(mappedBy = "role")
    private List<User> user;

    public Role(long l, RoleType roleType) {
    }
}
