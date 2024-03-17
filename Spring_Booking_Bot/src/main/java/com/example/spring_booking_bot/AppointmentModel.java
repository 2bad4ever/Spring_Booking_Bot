package com.example.spring_booking_bot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;

    // Конструкторы, геттеры и сеттеры
    public AppointmentModel() {
    }

    public AppointmentModel(long userId, String doctorName, LocalDateTime appointmentTime) {
        this.userId = userId;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
    }

    // Сюда добавим геттеры и сеттеры
}
