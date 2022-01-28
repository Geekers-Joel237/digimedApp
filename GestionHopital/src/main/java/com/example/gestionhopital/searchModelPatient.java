package com.example.gestionhopital;

import java.util.Date;

public class searchModelPatient {
    Integer idpatient;
    String nomPatient;
    String prenomPatient;
    Date dateNaissance;
    String sexe;
    String groupeSanguin;

    public searchModelPatient(Integer idpatient, String nomPatient, String prenomPatient, Date dateNaissance, String sexe, String groupeSanguin) {
        this.idpatient = idpatient;
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.groupeSanguin = groupeSanguin;
    }


    public Integer getIdPatient() {
        return idpatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public String getPrenomPatient() {
        return prenomPatient;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setIdPatient(Integer idPatient) {
        this.idpatient = idPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public void getDescription() {
    }
}
