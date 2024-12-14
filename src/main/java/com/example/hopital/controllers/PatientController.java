package com.example.hopital.controllers;

import com.example.hopital.models.Patient;
import com.example.hopital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Afficher la liste des patients
    @GetMapping("/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients"; // Retourne la vue patients.html
    }

    // Formulaire pour ajouter un patient
    @GetMapping("/add-patient")
    public String addPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient"; // Retourne la vue add-patient.html
    }

    // Enregistrer un patient
    @PostMapping("/add-patient")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients"; // Redirige vers la liste des patients
    }
    
    @GetMapping("/delete-patient/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients"; // Redirige vers la liste des patients
    }

}
