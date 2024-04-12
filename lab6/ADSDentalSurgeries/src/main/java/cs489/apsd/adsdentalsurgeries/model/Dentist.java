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
@Table(name = "dentists")
public class Dentist extends User{

    private String speciality;
    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}
