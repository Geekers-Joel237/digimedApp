package com.example.gestionhopital;

import java.util.Date;

public class searchModelConsultation {
    String Agents_idAgents;
    Integer patient_idpatient;
    String symptomes;
    String diagnostic;
    String traitement;
   Integer idConsultation;
   Date dateConsultation;

    public searchModelConsultation(String agents_idAgents, Integer patient_idpatient, String symptomes, String diagnostic, String traitement, Integer idConsultation, Date dateConsultation) {
        Agents_idAgents = agents_idAgents;
        this.patient_idpatient = patient_idpatient;
        this.symptomes = symptomes;
        this.diagnostic = diagnostic;
        this.traitement = traitement;
        this.idConsultation = idConsultation;
        this.dateConsultation = dateConsultation;
    }

    public String getAgents_idAgents() {
        return Agents_idAgents;
    }

    public Integer getPatient_idpatient() {
        return patient_idpatient;
    }

    public String getSymptomes() {
        return symptomes;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String getTraitement() {
        return traitement;
    }

    public Integer getIdConsultation() {
        return idConsultation;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setAgents_idAgents(String agents_idAgents) {
        Agents_idAgents = agents_idAgents;
    }

    public void setPatient_idpatient(Integer patient_idpatient) {
        this.patient_idpatient = patient_idpatient;
    }

    public void setSymptomes(String symptomes) {
        this.symptomes = symptomes;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public void setIdConsultation(Integer idConsultation) {
        this.idConsultation = idConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }
}
