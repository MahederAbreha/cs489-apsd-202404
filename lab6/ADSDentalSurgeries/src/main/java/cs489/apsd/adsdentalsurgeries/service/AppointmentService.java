package cs489.apsd.adsdentalsurgeries.service;

import cs489.apsd.adsdentalsurgeries.model.Appointment;

public interface AppointmentService {
    Appointment addNewAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment editedAppointment);
    void deleteAppointment(Integer appointmentId);
    Appointment getAppointmentById(Integer appointmentId);
    Appointment getAppointmentByPatientId(Integer patientId);
}
