package com.example.spring_booking_bot.repos;

import com.example.spring_booking_bot.models.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentModel, Long> {
    List<AppointmentModel> findByPatientId(Long patientId);
}
