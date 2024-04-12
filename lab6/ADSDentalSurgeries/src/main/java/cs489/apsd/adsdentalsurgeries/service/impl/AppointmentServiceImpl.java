package cs489.apsd.adsdentalsurgeries.service.impl;

import cs489.apsd.adsdentalsurgeries.model.Appointment;
import cs489.apsd.adsdentalsurgeries.repository.AppointmentRepository;
import cs489.apsd.adsdentalsurgeries.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment addNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment editedAppointment) {
        return null;
    }

    @Override
    public void deleteAppointment(Integer appointmentId) {

    }

    @Override
    public Appointment getAppointmentById(Integer appointmentId) {
        return null;
    }

    @Override
    public Appointment getAppointmentByPatientId(Integer patientId) {
        return null;
    }
}
