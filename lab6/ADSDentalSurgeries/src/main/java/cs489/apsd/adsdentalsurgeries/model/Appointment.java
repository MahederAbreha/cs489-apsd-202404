package cs489.apsd.adsdentalsurgeries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue
    private Integer appointmentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;
    @DateTimeFormat(pattern = "yyyy-MM-DD 'T' HH:mm")
    private LocalDateTime appointmentDateAndTime;

}
