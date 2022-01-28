package com.example.gestionhopital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class ListeAntecedantsController implements Initializable {

    @FXML
    private TableView<searchModelAntecedants> tableViewElement;
    @FXML
    private TableColumn<searchModelAntecedants,Integer> idAntecedantsColumn ;
    @FXML
    private TableColumn<searchModelAntecedants,String> etatDiabeteColumn ;
    @FXML
    private TableColumn<searchModelAntecedants,String> etatAsthmeColumn ;
    @FXML
    private TableColumn<searchModelAntecedants,String> etatUlcereColumn ;
    @FXML
    private TableColumn<searchModelAntecedants,String> etatInsuffisanceRenaleColumn ;
    @FXML
    private TableColumn<searchModelAntecedants,String> etatHypertensionArterielleColumn ;
    @FXML
    private TableColumn<searchModelAntecedants, String> allergieAlimentaireColumn ;
    @FXML
    private TableColumn<searchModelAntecedants,Integer> idPatientColumn ;
    @FXML
    private TableColumn<searchModelAntecedants,String> allergieMedicaleColumn ;
    @FXML
    private TableColumn<searchModelAntecedants, String> antecedantsChirurgicauxColumn ;

    ObservableList<searchModelAntecedants> antecedantsModelSearchObservable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT  idAntecedants,etatDiabete,etatAsthme,etatUlcere,etatInsuffisanceRenale,etatHypertensionArterielle,allergieAlimentaire,patient_idpatient,allergieMedicale,antecedantsChirurgicaux FROM antecedants";


        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()){
                Integer queryIdAntecedant = queryOutput.getInt("idAntecedants");
                String queryetatDiabete = queryOutput.getString("etatDiabete");
                String queryEtatAsthme = queryOutput.getString("etatAsthme");
                String queryEtatUlcere = queryOutput.getString("etatUlcere");
                String queryEtatInsuffisanceRenale = queryOutput.getString("etatInsuffisanceRenale");
                String queryHypArt = queryOutput.getString("etatHypertensionArterielle");
                String queryAllergieAlimentaire = queryOutput.getString("allergieAlimentaire");
                Integer queryIdpatient = queryOutput.getInt("patient_idpatient");
                String queryAllerMed = queryOutput.getString("allergieMedicale");
                String queryAntChir = queryOutput.getString("antecedantsChirurgicaux");



                antecedantsModelSearchObservable.add(new searchModelAntecedants(queryIdAntecedant,queryetatDiabete,queryEtatAsthme,queryEtatUlcere,queryEtatInsuffisanceRenale,queryHypArt,queryAllergieAlimentaire,queryIdpatient,queryAllerMed,queryAntChir));
            }

            idAntecedantsColumn.setCellValueFactory(new PropertyValueFactory<>("idAntecedants"));
            etatDiabeteColumn.setCellValueFactory(new PropertyValueFactory<>("etatDiabete"));
            etatAsthmeColumn.setCellValueFactory(new PropertyValueFactory<>("etatAsthme"));
            etatUlcereColumn.setCellValueFactory(new PropertyValueFactory<>("etatUlcere"));
            etatInsuffisanceRenaleColumn.setCellValueFactory(new PropertyValueFactory<>("etatInsuffisanceRenale"));
            etatHypertensionArterielleColumn.setCellValueFactory(new PropertyValueFactory<>("etatHypertensionArterielle"));
            allergieAlimentaireColumn.setCellValueFactory(new PropertyValueFactory<>("allergieAlimentaire"));
            idPatientColumn.setCellValueFactory(new PropertyValueFactory<>("patient_idpatient"));
            allergieMedicaleColumn.setCellValueFactory(new PropertyValueFactory<>("allergieMedicale"));
            antecedantsChirurgicauxColumn.setCellValueFactory(new PropertyValueFactory<>("antecedantsChirurgicaux"));

            tableViewElement.setItems(antecedantsModelSearchObservable);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("erreurs");
        }

    }


}

