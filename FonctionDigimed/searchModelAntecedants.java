package com.example.gestionhopital;

public class searchModelAntecedants {
    Integer idAntecedants;
    String etatDiabete;
    String etatAsthme;
    String etatUlcere;
    String etatInsuffisanceRenale;
    String etatHypertensionArterielle;
    String allergieAlimentaire;
    Integer patient_idpatient;
    String allergieMedicale;
    String antecedantsChirurgicaux;

    public searchModelAntecedants(Integer idAntecedants,String	etatDiabete,String	etatAsthme,String etatUlcere,String etatInsuffisanceRenale,String	etatHypertensionArterielle,String	allergieAlimentaire, Integer patient_idpatient	,String allergieMedicale,String	antecedantsChirurgicaux){
        this.idAntecedants = idAntecedants;
        this.etatDiabete = etatDiabete;
        this.etatAsthme = etatAsthme;
        this.etatUlcere = etatUlcere;
        this.etatInsuffisanceRenale = etatInsuffisanceRenale;
        this.etatHypertensionArterielle = etatHypertensionArterielle;
        this.allergieAlimentaire = allergieAlimentaire;
        this.patient_idpatient = patient_idpatient;
        this.allergieMedicale = allergieMedicale;
        this.antecedantsChirurgicaux = antecedantsChirurgicaux;

    }

    public Integer getIdAntecedants() {
        return idAntecedants;
    }

    public String getEtatDiabete() {
        return etatDiabete;
    }

    public String getEtatInsuffisanceRenale() {
        return etatInsuffisanceRenale;
    }

    public String getAllergieAlimentaire() {
        return allergieAlimentaire;
    }

    public String getEtatAsthme() {
        return etatAsthme;
    }

    public String getEtatUlcere() {
        return etatUlcere;
    }

    public String getEtatHypertensionArterielle() {
        return etatHypertensionArterielle;
    }

    public Integer getPatient_idpatient() {
        return patient_idpatient;
    }

    public String getAllergieMedicale() {
        return allergieMedicale;
    }

    public String getAntecedantsChirurgicaux() {
        return antecedantsChirurgicaux;
    }

    public void setAllergieAlimentaire(String allergieAlimentaire) {
        this.allergieAlimentaire = allergieAlimentaire;
    }

    public void setEtatAsthme(String etatAsthme) {
        this.etatAsthme = etatAsthme;
    }

    public void setEtatDiabete(String etatDiabete) {
        this.etatDiabete = etatDiabete;
    }

    public void setEtatUlcere(String etatUlcere) {
        this.etatUlcere = etatUlcere;
    }

    public void setEtatHypertensionArterielle(String etatHypertensionArterielle) {
        this.etatHypertensionArterielle = etatHypertensionArterielle;
    }

    public void setEtatInsuffisanceRenale(String etatInsuffisanceRenale) {
        this.etatInsuffisanceRenale = etatInsuffisanceRenale;
    }

    public void setIdAntecedants(Integer idAntecedants) {
        this.idAntecedants = idAntecedants;
    }

    public void setAllergieMedicale(String allergieMedicale) {
        this.allergieMedicale = allergieMedicale;
    }

    public void setAntecedantsChirurgicaux(String antecedantsChirurgicaux) {
        this.antecedantsChirurgicaux = antecedantsChirurgicaux;
    }

    public void setPatient_idpatient(Integer patient_idpatient) {
        this.patient_idpatient = patient_idpatient;
    }
}
