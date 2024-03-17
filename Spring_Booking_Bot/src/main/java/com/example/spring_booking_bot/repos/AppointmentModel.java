package com.example.spring_booking_bot.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;

    // Конструкторы
    public AppointmentModel() {
    }

    public AppointmentModel(long patientId, String doctorName, LocalDateTime appointmentTime) {
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
    }

    // Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
