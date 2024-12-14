package com.example.hopital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hopital.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
