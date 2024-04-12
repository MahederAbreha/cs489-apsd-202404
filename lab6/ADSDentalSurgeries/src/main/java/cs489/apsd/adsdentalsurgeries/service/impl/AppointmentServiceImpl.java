package cs489.apsd.adsdentalsurgeries.service.impl;

import cs489.apsd.adsdentalsurgeries.model.Appointment;
import cs489.apsd.adsdentalsurgeries.repository.AppointmentRepository;
import cs489.apsd.adsdentalsurgeries.repository.DentistRepository;
import cs489.apsd.adsdentalsurgeries.repository.PatientRepository;
import cs489.apsd.adsdentalsurgeries.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepository appointmentRepository;
    PatientRepository patientRepository;
    DentistRepository dentistRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DentistRepository dentistRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Appointment addNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Integer appointmentId, Appointment editedAppointment) {
        Appointment appointmentToUpdate = appointmentRepository.findById(appointmentId).orElse(null);
        if (appointmentToUpdate != null) {
            appointmentToUpdate.setAppointmentDateAndTime(editedAppointment.getAppointmentDateAndTime());
            appointmentToUpdate.setDentist(editedAppointment.getDentist());
            appointmentToUpdate.setPatient(editedAppointment.getPatient());
            appointmentToUpdate.setSurgery(editedAppointment.getSurgery());
             return appointmentRepository.save(appointmentToUpdate);
        }
        return null;
    }

    @Override
    public void deleteAppointment(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public Appointment getAppointmentById(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

}
