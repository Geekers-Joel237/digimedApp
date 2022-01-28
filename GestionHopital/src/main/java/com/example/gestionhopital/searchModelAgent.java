package com.example.gestionhopital;

public class searchModelAgent {
    String idAgents;
    String nomAgent;
    String prenomAgent;
    String telephone;
    String specialite;
    String lieuIntervention;

    public searchModelAgent(String idAgents, String nomAgent, String prenomAgent, String telephone, String specialite, String lieuIntervention) {
        this.idAgents = idAgents;
        this.nomAgent = nomAgent;
        this.prenomAgent = prenomAgent;
        this.telephone = telephone;
        this.specialite = specialite;
        this.lieuIntervention = lieuIntervention;
    }

    public String getIdAgents() {
        return idAgents;
    }

    public String getNomAgent() {
        return nomAgent;
    }

    public String getPrenomAgent() {
        return prenomAgent;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getLieuIntervention() {
        return lieuIntervention;
    }

    public void setIdAgents(String idAgents) {
        this.idAgents = idAgents;
    }

    public void setNomAgent(String nomAgent) {
        this.nomAgent = nomAgent;
    }

    public void setPrenomAgent(String prenomAgent) {
        this.prenomAgent = prenomAgent;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setLieuIntervention(String lieuIntervention) {
        this.lieuIntervention = lieuIntervention;
    }
}
