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
@Table(name = "surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryId;
    private String name;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surgery", fetch = FetchType.EAGER)
    private List<Appointment> appointments;
}
