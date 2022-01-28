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

public class GestionDesAgentController implements  Initializable{

    @FXML
    TextField idAgentTextField;
    @FXML
    TextField nomAgentTextField;
    @FXML
    TextField prenomAgentTextField;
    @FXML
    TextField specialiteAgentTextField;
    @FXML
    TextField telephoneAgentTextField;
    @FXML
    TextField lieuAgentTextField;
    @FXML
    Button addButton;
    @FXML
    Button DelateButton;
    @FXML
    Button UpdateButton;
    @FXML
    Button emptyButton;
    @FXML
    private TableView<searchModelAgent> tableViewElement;
    @FXML
    private TableColumn<searchModelAgent,String> idColum;
    @FXML
    private TableColumn<searchModelAgent,String> nomColum;
    @FXML
    private TableColumn<searchModelAgent,String> prenomColum;
    @FXML
    private TableColumn<searchModelAgent,String> specialiteColum;
    @FXML
    private TableColumn<searchModelAgent,String> telephoneColum;
    @FXML
    private TableColumn<searchModelAgent,String> lieuColum;
    @FXML
    private TextField searchFieldLable;
    @FXML
    private Button searchButton;


    ObservableList<searchModelAgent> patientModelSearchObservable = FXCollections.observableArrayList();

    public void initialize(URL url , ResourceBundle resourceBundle ){
        /*File brandingFile = new File("image/woman-g2446c42e4_1920.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);*/

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT idAgents ,nomAgent , prenomAgent , telephone ,specialite , lieuIntervention FROM agents";
        // String PatientQuery = "SELECT count(1) FROM patient";


        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()){
                String queryIdPatient = queryOutput.getString("idAgents");
                String queryNom = queryOutput.getString("nomAgent");
                String queryPrenom = queryOutput.getString("prenomAgent");
                String queryDate = queryOutput.getString("telephone");
                String querySexe = queryOutput.getString("specialite");
                String queryGroupe = queryOutput.getString("lieuIntervention");


                patientModelSearchObservable.add(new searchModelAgent(queryIdPatient,queryNom,queryPrenom,queryDate,querySexe,queryGroupe));
            }

            idColum.setCellValueFactory(new PropertyValueFactory<>("idAgents"));
            nomColum.setCellValueFactory(new PropertyValueFactory<>("nomAgent"));
            prenomColum.setCellValueFactory(new PropertyValueFactory<>("prenomAgent"));
            specialiteColum.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            telephoneColum.setCellValueFactory(new PropertyValueFactory<>("specialite"));
            lieuColum.setCellValueFactory(new PropertyValueFactory<>("lieuIntervention"));

            tableViewElement.setItems(patientModelSearchObservable);


        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("erreur");
        }

    }

    public void addRegister(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idAgent = idAgentTextField.getText();
        String nomAgent = nomAgentTextField.getText();
        String prenomAgent =prenomAgentTextField.getText();
        String telephone = telephoneAgentTextField.getText();
        String specialite = specialiteAgentTextField.getText();
        String lieu =lieuAgentTextField.getText();


        String insertField = "INSERT INTO agents(idAgents,nomAgent,prenomAgent,telephone,specialite,lieuIntervention ) VALUES ('";
        String insertValue =  idAgent + "','" +nomAgent + "','" +prenomAgent + "','" + telephone + "','" +specialite + "','" + lieu+ "')";
        String insertToRegister = insertField + insertValue;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void refreshRegisterOnAction(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT idAgents ,nomAgent , prenomAgent , telephone ,specialite , lieuIntervention FROM agents";
        // String PatientQuery = "SELECT count(1) FROM patient";

            patientModelSearchObservable.clear();
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()){
                String queryIdPatient = queryOutput.getString("idAgents");
                String queryNom = queryOutput.getString("nomAgent");
                String queryPrenom = queryOutput.getString("prenomAgent");
                String queryDate = queryOutput.getString("telephone");
                String querySexe = queryOutput.getString("specialite");
                String queryGroupe = queryOutput.getString("lieuIntervention");


                patientModelSearchObservable.add(new searchModelAgent(queryIdPatient,queryNom,queryPrenom,queryDate,querySexe,queryGroupe));
            }

            idColum.setCellValueFactory(new PropertyValueFactory<>("idAgents"));
            nomColum.setCellValueFactory(new PropertyValueFactory<>("nomAgent"));
            prenomColum.setCellValueFactory(new PropertyValueFactory<>("prenomAgent"));
            specialiteColum.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            telephoneColum.setCellValueFactory(new PropertyValueFactory<>("specialite"));
            lieuColum.setCellValueFactory(new PropertyValueFactory<>("lieuIntervention"));

            tableViewElement.setItems(patientModelSearchObservable);


        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("erreur");
        }

    }

    public void delateRgister(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idagent = idAgentTextField.getText();
        String query = "DELETE FROM `agents` WHERE idAgents = '"+ idagent+"'" ;
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

    public void updateRegister(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idAgent = idAgentTextField.getText();
        String nomAgent = nomAgentTextField.getText();
        String prenomAgent =prenomAgentTextField.getText();
        String telephone = telephoneAgentTextField.getText();
        String specialite = specialiteAgentTextField.getText();
        String lieu =lieuAgentTextField.getText();



        String query = "UPDATE agents SET"
                + "`nomAgent` =?,"
                + "`prenomAgent`=?,"
                + "`telephone`=?,"
                + "`specialite`=?,"
                + "`lieuIntervention`=? WHERE idAgents = '"+ idAgent+"'";


        try {
            PreparedStatement prepare = connectDB.prepareStatement(query);
            prepare.setString(1,nomAgent);
            prepare.setString(2,prenomAgent);
            prepare.setString(3,telephone);
            prepare.setString(4,specialite);
            prepare.setString(5,lieu);

            prepare.executeUpdate();
            // Statement statement = connectDB.createStatement();
            //statement.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void emptyLableOnAction(){
        idAgentTextField.setText("");
        nomAgentTextField.setText("");
        prenomAgentTextField.setText("");
        telephoneAgentTextField.setText("");
        specialiteAgentTextField.setText("");
        lieuAgentTextField.setText("");

    }

    public void searchRegisterOnAction(){
        //SELECT * FROM `patient` WHERE nomPatient = 'Fozeu'

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT * FROM `agents` WHERE nomAgent  = '"+searchFieldLable.getText()+"'" ;
        patientModelSearchObservable.clear();
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()){
                String queryIdAgent = queryOutput.getString("idAgents");
                String queryNom = queryOutput.getString("nomAgent");
                String queryPrenom = queryOutput.getString("prenomAgent");
                String queryTelephone = queryOutput.getString("telephone");
                String querySpecialite = queryOutput.getString("specialite");
                String queryLieu = queryOutput.getString("lieuIntervention");


                patientModelSearchObservable.add(new searchModelAgent(queryIdAgent,queryNom,queryPrenom,queryTelephone,querySpecialite,queryLieu));
            }


            idColum.setCellValueFactory(new PropertyValueFactory<>("idAgents"));
            nomColum.setCellValueFactory(new PropertyValueFactory<>("nomAgent"));
            prenomColum.setCellValueFactory(new PropertyValueFactory<>("prenomAgent"));
            telephoneColum.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            specialiteColum.setCellValueFactory(new PropertyValueFactory<>("specialite"));
            lieuColum.setCellValueFactory(new PropertyValueFactory<>("lieuIntervention"));

            tableViewElement.setItems(patientModelSearchObservable);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("erreur");
        }



    }




}
