package com.example.gestionhopital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AntecedantController implements Initializable {

    @FXML
    TextField idantecedent;
    @FXML
    TextField idpatient;
    @FXML
    Button addButton;
    @FXML
    Button DelateButton;
    @FXML
    Button UpdateButton;
    @FXML
    Button emptyButton;
    @FXML
    RadioButton radio1True;
    @FXML
    RadioButton radio1False;
    @FXML
    RadioButton radio2True;
    @FXML
    RadioButton radio2False;
    @FXML
    RadioButton radio3True;
    @FXML
    RadioButton radio3False;
    @FXML
    RadioButton radio4True;
    @FXML
    RadioButton radio4False;
    @FXML
    RadioButton radio5True;
    @FXML
    RadioButton radio5False;
    @FXML
    TextArea achirurgicaux;
    @FXML
    TextArea aalimentaire;
    @FXML
    TextArea amedicale;



    public void addRegister(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idAntecedant = idantecedent.getText();
        String  idPatient = idpatient.getText();
        String aAlimentaire =aalimentaire.getText();
        String aMedicale = amedicale.getText();
        String aChirurgicaux= achirurgicaux.getText();
       // String allergieMecicale= aalimentaire.getText();


        String radio1true ="0 " ;
        String radio2true="0 " ;
       String radio3true=" 0" ;
        String radio4true =" 0";
        String radio5true =" 0";

        if(radio1True.isSelected()) {
            radio1true = "Oui";
        }
        else if (radio1False.isSelected()){radio1true = "Non" ;}
        if(radio2True.isSelected()) {
            radio2true = "Oui";
        }
        else if (radio2False.isSelected()){radio2true = "Non" ;}
        if(radio3True.isSelected()) {
            radio3true = "Oui";
        }
        else if (radio3False.isSelected()){radio3true = "Non" ;}
        if(radio4True.isSelected()) {
            radio4true = "Oui";
        }
        else if (radio4False.isSelected()){radio4true = "Non" ;}

        if(radio5True.isSelected()) {
            radio5true = "Oui";
        }
        else if (radio5False.isSelected()){radio5true = "Non" ;}




        String insertField = "INSERT INTO antecedants( idAntecedants,etatDiabete,etatAsthme,etatUlcere,etatInsuffisanceRenale,etatHypertensionArterielle,allergieAlimentaire,patient_idpatient,allergieMedicale,antecedantsChirurgicaux) VALUES ('";
        String insertValue =  idAntecedant + "','" + radio1true + "','" + radio5true + "','" +  radio2true  + "','" +radio3true + "','" + radio4true+ "','" + aAlimentaire + "','" + idPatient + "','" + aMedicale + "','" +aChirurgicaux + "')";
        String insertToRegister = insertField + insertValue;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
    }

    public void updateRegister(){
        //UPDATE `patient` SET `prenomPatient` = 'Veronique' WHERE `patient`.`idpatient` = 2;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idAntecedant = idantecedent.getText();
        String  idPatient = idpatient.getText();
        String aAlimentaire =aalimentaire.getText();
        String aMedicale = amedicale.getText();
        String aChirurgicaux= achirurgicaux.getText();
        // String allergieMecicale= aalimentaire.getText();

        String radio1true ="0 " ;
        String radio2true="0 " ;
        String radio3true=" 0" ;
        String radio4true =" 0";
        String radio5true =" 0";

        if(radio1True.isSelected()) {
            radio1true = "Oui";
        }
        else if (radio1False.isSelected()){radio1true = "Non" ;}
        if(radio2True.isSelected()) {
            radio2true = "Oui";
        }
        else if (radio2False.isSelected()){radio2true = "Non" ;}
        if(radio3True.isSelected()) {
            radio3true = "Oui";
        }
        else if (radio3False.isSelected()){radio3true = "Non" ;}
        if(radio4True.isSelected()) {
            radio4true = "Oui";
        }
        else if (radio4False.isSelected()){radio4true = "Non" ;}

        if(radio5True.isSelected()) {
            radio5true = "Oui";
        }
        else if (radio5False.isSelected()){radio5true = "Non" ;}


        String insertField = "UPDATE antecedants idAntecedants,etatDiabete,etatAsthme,etatUlcere,etatInsuffisanceRenale,etatHypertensionArterielle,allergieAlimentaire,patient_idpatient,allergieMedicale,antecedantsChirurgicaux  WHERE idAntecedants ('";
        String insertValue =   radio1true + "','" + radio5true + "','" +  radio2true  + "','" +radio3true + "','" + radio4true+ "','" + aAlimentaire + "','" + idPatient + "','" + aMedicale +"')";
        String insertToRegister = insertField + insertValue;

        String query = "UPDATE antecedants SET"
                + "`etatDiabete` =?,"
                + "`etatAsthme`=?,"
                + "`etatUlcere`=?,"
                + "`etatInsuffisanceRenale`=?,"
                + "`etatHypertensionArterielle`=?,"
                + "`allergieAlimentaire`=?,"
                + "`patient_idpatient`=?,"
                + "`allergieMedicale`=?,"
                + "`antecedantsChirurgicaux`=? WHERE idAntecedants = '"+idAntecedant +"'";


        try {
            PreparedStatement prepare = connectDB.prepareStatement(query);
            prepare.setString(1, radio1true);
            prepare.setString(2, radio5true);
            prepare.setString(3, radio2true);
            prepare.setString(4,radio3true);
            prepare.setString(5, radio4true);
            prepare.setString(6, aAlimentaire);
            prepare.setString(7, idPatient);
            prepare.setString(8, aMedicale);
            prepare.setString(9, aChirurgicaux);

            prepare.executeUpdate();
            // Statement statement = connectDB.createStatement();
            //statement.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void delateRgister(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idantecedant = idantecedent.getText();
        String query = "DELETE FROM `antecedants` WHERE idAntecedants = '"+ idantecedant+"'" ;
        try{
            PreparedStatement prepare = connectDB.prepareStatement(query);
            prepare.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clear(){
        idantecedent.setText("");
        idpatient.setText("");
        aalimentaire.setText("");
        amedicale.setText("");
        achirurgicaux.setText("");
    }

    public void rechargeListe(ActionEvent event)throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("listeAntecedants.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erreursss");
        }
    }

}
