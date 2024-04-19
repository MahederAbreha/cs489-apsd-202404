package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment addNewAppointment(Appointment appointment);
    Appointment updateAppointment(Integer appointmentId, Appointment editedAppointment);
    void deleteAppointment(Integer appointmentId);
    Appointment getAppointmentById(Integer appointmentId);
    List<Appointment> getAllAppointments();
}
