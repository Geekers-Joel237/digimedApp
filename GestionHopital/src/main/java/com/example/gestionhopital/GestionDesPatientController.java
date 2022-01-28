package com.example.gestionhopital;

import com.mysql.cj.util.StringUtils;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;

import java.security.MessageDigest;
import java.sql.*;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.net.URL;
import java.io.File;

public class GestionDesPatientController implements  Initializable  {

    @FXML
    private ImageView brandingImageView ;
    @FXML
    private TableView<searchModelPatient> tableViewElement ;
    @FXML
    private TableColumn<searchModelPatient,Integer> idPatientColum ;
    @FXML
    private TableColumn<searchModelPatient,String> nomColum;
    @FXML
    private TableColumn<searchModelPatient,String> prenomColum;
    @FXML
    private TableColumn<searchModelPatient,Date> dateColum;
    @FXML
    private TableColumn<searchModelPatient,String> sexeColum;
    @FXML
    private TableColumn<searchModelPatient,String> groupeColum;
    @FXML
    private TextField searchFieldLable;
    @FXML
    private TextField idPatientFieldLable;
    @FXML
    private TextField nomFieldLable;
    @FXML
    private TextField prenomFieldLable;
    @FXML
     private TextField dateFieldLable;
    @FXML
    private TextField sexeFieldLable;
    @FXML
    private TextField groupeFieldLable;
    @FXML



    ObservableList<searchModelPatient> patientModelSearchObservable = FXCollections.observableArrayList();




    public void initialize(URL url , ResourceBundle resourceBundle ){
        /*File brandingFile = new File("image/woman-g2446c42e4_1920.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);*/

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

          String PatientQuery = "SELECT idpatient ,nomPatient , prenomPatient , dateNaissance ,sexe , groupeSanguin FROM patient";
          // String PatientQuery = "SELECT count(1) FROM patient";


        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()){
                Integer queryIdPatient = queryOutput.getInt("idPatient");
                String queryNom = queryOutput.getString("nomPatient");
                String queryPrenom = queryOutput.getString("prenomPatient");
                Date queryDate = queryOutput.getDate("dateNaissance");
                String querySexe = queryOutput.getString("sexe");
                String queryGroupe = queryOutput.getString("groupeSanguin");


                patientModelSearchObservable.add(new searchModelPatient(queryIdPatient,queryNom,queryPrenom,queryDate,querySexe,queryGroupe));
            }

            idPatientColum.setCellValueFactory(new PropertyValueFactory<>("idPatient"));
            nomColum.setCellValueFactory(new PropertyValueFactory<>("nomPatient"));
            prenomColum.setCellValueFactory(new PropertyValueFactory<>("prenomPatient"));
            dateColum.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
            sexeColum.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            groupeColum.setCellValueFactory(new PropertyValueFactory<>("groupeSanguin"));

            tableViewElement.setItems(patientModelSearchObservable);

            //recherche
            FilteredList<searchModelPatient> filteredData = new FilteredList<>(patientModelSearchObservable , b-> true);

            searchFieldLable.textProperty().addListener((observable , oldValue , newValue)->{
                filteredData.setPredicate(searchModelPatient -> {
                    if(newValue.isEmpty() || newValue.isBlank()|| newValue==null){

                        String searchKeyWord = newValue.toLowerCase(Locale.ROOT);

                        if(searchModelPatient.getNomPatient().toLowerCase(Locale.ROOT).indexOf(searchKeyWord)>1 ){
                            return true;
                        }else {return false;}
                    }else
                        return false;
                });
            });
            // fin

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("erreur");
        }

    }
    public void addRegister(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idpatient = idPatientFieldLable.getText();
        String nomPatient = nomFieldLable.getText();
        String prenomPatient =prenomFieldLable.getText();
        String date = dateFieldLable.getText();
        String sexe = sexeFieldLable.getText();
        String groupe =groupeFieldLable.getText();


        String insertField = "INSERT INTO  patient(idpatient,nomPatient,prenomPatient,dateNaissance,sexe,groupeSanguin ) VALUES ('";
        String insertValue =  idpatient + "','" + nomPatient + "','" + prenomPatient + "','" + date + "','" + sexe + "','" + groupe + "')";
        String insertToRegister = insertField + insertValue;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void adOnRegister(ActionEvent event){
        addRegister();
    }
    public void refreshOnRegister(ActionEvent event){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT idpatient ,nomPatient , prenomPatient , dateNaissance ,sexe , groupeSanguin FROM patient";
        // String PatientQuery = "SELECT count(1) FROM patient";
        patientModelSearchObservable.clear();
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()){
                Integer queryIdPatient = queryOutput.getInt("idpatient");
                String queryNom = queryOutput.getString("nomPatient");
                String queryPrenom = queryOutput.getString("prenomPatient");
                Date queryDate = queryOutput.getDate("dateNaissance");
                String querySexe = queryOutput.getString("sexe");
                String queryGroupe = queryOutput.getString("groupeSanguin");


                patientModelSearchObservable.add(new searchModelPatient(queryIdPatient,queryNom,queryPrenom,queryDate,querySexe,queryGroupe));
            }


            idPatientColum.setCellValueFactory(new PropertyValueFactory<>("idPatient"));
            nomColum.setCellValueFactory(new PropertyValueFactory<>("nomPatient"));
            prenomColum.setCellValueFactory(new PropertyValueFactory<>("prenomPatient"));
            dateColum.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
            sexeColum.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            groupeColum.setCellValueFactory(new PropertyValueFactory<>("groupeSanguin"));

            tableViewElement.setItems(patientModelSearchObservable);


        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("erreur");
        }
    }

    public void updateRegister(){
        //UPDATE `patient` SET `prenomPatient` = 'Veronique' WHERE `patient`.`idpatient` = 2;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idpatient = idPatientFieldLable.getText();
        String nomPatient = nomFieldLable.getText();
        String prenomPatient =prenomFieldLable.getText();
        String date = dateFieldLable.getText();
        String sexe = sexeFieldLable.getText();
        String groupe =groupeFieldLable.getText();

        String insertField = "UPDATE patient idpatient,nomPatient,prenomPatient,dateNaissance,sexe,groupeSanguin  WHERE idpatient ('";
        String insertValue =  idpatient + "','" + nomPatient + "','" + prenomPatient + "','" + date + "','" + sexe + "','" + groupe + "')";
        String insertToRegister = insertField + insertValue;

        String query = "UPDATE patient SET"
                + "`nomPatient` =?,"
                + "`prenomPatient`=?,"
                + "`dateNaissance`=?,"
                + "`sexe`=?,"
                + "`groupeSanguin`=? WHERE idpatient = '"+ idpatient+"'";


        try {
            PreparedStatement prepare = connectDB.prepareStatement(query);
            prepare.setString(1,nomPatient);
            prepare.setString(2,prenomPatient);
            prepare.setString(3,date);
            prepare.setString(4,sexe);
            prepare.setString(5,groupe);

            prepare.executeUpdate();
           // Statement statement = connectDB.createStatement();
            //statement.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateOnActionRegister(ActionEvent event){
        updateRegister();
    }

    public void delateRgister(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idpatient = idPatientFieldLable.getText();
        String query = "DELETE FROM `patient` WHERE idpatient = '"+ idpatient+"'" ;
        try{
            PreparedStatement prepare = connectDB.prepareStatement(query);
            prepare.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delateRegisterOnAction(){
        delateRgister();
    }

    public void emptyLableOnAction(){
        idPatientFieldLable.setText("");
        nomFieldLable.setText("");
        prenomFieldLable.setText("");
        dateFieldLable.setText("");
        sexeFieldLable.setText("");
        groupeFieldLable.setText("");

    }
    public void searchRegisterOnAction(){
        //SELECT * FROM `patient` WHERE nomPatient = 'Fozeu'

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT * FROM `patient` WHERE nomPatient  = '"+searchFieldLable.getText()+"'" ;
        patientModelSearchObservable.clear();
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()){
                Integer queryIdPatient = queryOutput.getInt("idpatient");
                String queryNom = queryOutput.getString("nomPatient");
                String queryPrenom = queryOutput.getString("prenomPatient");
                Date queryDate = queryOutput.getDate("dateNaissance");
                String querySexe = queryOutput.getString("sexe");
                String queryGroupe = queryOutput.getString("groupeSanguin");


                patientModelSearchObservable.add(new searchModelPatient(queryIdPatient,queryNom,queryPrenom,queryDate,querySexe,queryGroupe));
            }


            idPatientColum.setCellValueFactory(new PropertyValueFactory<>("idPatient"));
            nomColum.setCellValueFactory(new PropertyValueFactory<>("nomPatient"));
            prenomColum.setCellValueFactory(new PropertyValueFactory<>("prenomPatient"));
            dateColum.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
            sexeColum.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            groupeColum.setCellValueFactory(new PropertyValueFactory<>("groupeSanguin"));

            tableViewElement.setItems(patientModelSearchObservable);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("erreur");
        }



    }

}
