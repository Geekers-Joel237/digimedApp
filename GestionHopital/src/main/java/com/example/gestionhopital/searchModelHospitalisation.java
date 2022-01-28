package com.example.gestionhopital;
import java.util.Date;
public class searchModelHospitalisation {

    Integer idHospitalisations;
    Date dateHospitalisation;
    String centre;
    String motif;
    Integer patient_idpatient;

    public searchModelHospitalisation(Integer idHospitalisations, Date dateHospitalisation, String centre, String motif, Integer patient_idpatient) {
        this.idHospitalisations = idHospitalisations;
        this.dateHospitalisation = dateHospitalisation;
        this.centre = centre;
        this.motif = motif;
        this.patient_idpatient = patient_idpatient;
    }

    public Integer getIdHospitalisations() {
        return idHospitalisations;
    }

    public Date getDateHospitalisation() {
        return dateHospitalisation;
    }

    public String getCentre() {
        return centre;
    }

    public String getMotif() {
        return motif;
    }

    public Integer getPatient_idpatient() {
        return patient_idpatient;
    }

    public void setIdHospitalisations(Integer idHospitalisations) {
        this.idHospitalisations = idHospitalisations;
    }

    public void setDateHospitalisation(Date dateHospitalisation) {
        this.dateHospitalisation = dateHospitalisation;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setPatient_idpatient(Integer patient_idpatient) {
        this.patient_idpatient = patient_idpatient;
    }
}
