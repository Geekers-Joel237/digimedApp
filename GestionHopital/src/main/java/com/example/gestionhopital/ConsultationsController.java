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
public class ConsultationsController implements Initializable {

    @FXML
    private DatePicker datapick;
    @FXML
    private TextField symptomeTextField;
    @FXML
    private TextField idAgentTextField;
    @FXML
    private TextField diagnosticTextField;
    @FXML
    private TextField idpatientTextField;
    @FXML
    private TextField traitementTextField;
    @FXML
    private TextField idConsultationTextField;
    @FXML
    private TableView<searchModelConsultation> tableViewElement;
    @FXML
    private TableColumn<searchModelConsultation,String> idAgentColum ;
    @FXML
    private TableColumn<searchModelConsultation,Integer> idPatientColum ;
    @FXML
    private TableColumn<searchModelConsultation,String> idSymptometColum ;
    @FXML
    private TableColumn<searchModelConsultation,Integer> idPDateColum ;
    @FXML
    private TableColumn<searchModelConsultation,String> idDiagnostictColum ;
    @FXML
    private TableColumn<searchModelConsultation,String> idTraitementColum ;
    @FXML
    private TableColumn<searchModelConsultation,Date> idDateColum ;
    @FXML
     private Button addButton;

    ObservableList<searchModelConsultation> consultationModelSearchObservable = FXCollections.observableArrayList();

    public void initialize(URL url , ResourceBundle resourceBundle) {


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

       String PatientQuery = "SELECT  Agents_idAgents , patient_idpatient ,symptomes ,diagnostic ,traitement ,idConsultation ,dateConsultation FROM consultations";
       // String PatientQuery = "SELECT * FROM consultations";
       /*  String Agents_idAgents;
    Integer patient_idpatient;
    String symptomes;
    String diagnostic;
    String traitement;
   Integer idConsultation;
   Date dateConsultation;*/

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()){
                String queryIdAgent = queryOutput.getString("Agents_idAgents");
                Integer queryIdpatient = queryOutput.getInt("patient_idpatient");
                String queryIdSymptome = queryOutput.getString("symptomes");
                String querydiacnostic = queryOutput.getString("diagnostic");
                String querytraitement = queryOutput.getString("traitement");
                Integer queryconsultation = queryOutput.getInt("idConsultation");
                Date queryDateCons = queryOutput.getDate("dateConsultation");


                consultationModelSearchObservable.add(new searchModelConsultation(queryIdAgent,queryIdpatient,queryIdSymptome,querydiacnostic,querytraitement,queryconsultation,queryDateCons));
            }

            idAgentColum.setCellValueFactory(new PropertyValueFactory<>("Agents_idAgents"));
            idPatientColum.setCellValueFactory(new PropertyValueFactory<>("patient_idpatient"));
            idDateColum.setCellValueFactory(new PropertyValueFactory<>("symptomes"));
            idSymptometColum.setCellValueFactory(new PropertyValueFactory<>("diagnostic"));
            idDiagnostictColum.setCellValueFactory(new PropertyValueFactory<>("traitement"));
            idTraitementColum.setCellValueFactory(new PropertyValueFactory<>("idConsultation"));
            idPDateColum.setCellValueFactory(new PropertyValueFactory<>("dateConsultation"));

            tableViewElement.setItems(consultationModelSearchObservable);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("erreurs");
        }

    }

   public void addOnreGister(){

          /*  String Agents_idAgents;
    Integer patient_idpatient;
    String symptomes;
    String diagnostic;
    String traitement;
   Integer idConsultation;
   Date dateConsultation;*/

       DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idAgent = idAgentTextField.getText();
        String idPatient = idpatientTextField.getText();
        String idConsultation =idConsultationTextField.getText();
        String Symptome = symptomeTextField.getText();
        String diagnostic = diagnosticTextField.getText();
        String traitement =traitementTextField.getText();
        String date = datapick.getValue().toString();

        String insertField = "INSERT INTO  consultations(Agents_idAgents , patient_idpatient ,symptomes ,diagnostic ,traitement ,idConsultation , dateConsultation  ) VALUES ('";
        String insertValue =  idAgent + "','" +idPatient + "','" + Symptome + "','" + diagnostic + "','" + traitement + "','" +idConsultation + "','" + date + "')";
        String insertToRegister = insertField + insertValue;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

        }catch (Exception e){
            e.printStackTrace();
        }

       refreshRegister();
    }

    public void updateOnRegister(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idAgent = idAgentTextField.getText();
        String idPatient = idpatientTextField.getText();
        String idConsultation =idConsultationTextField.getText();
        String Symptome = symptomeTextField.getText();
        String diagnostic = diagnosticTextField.getText();
        String traitement =traitementTextField.getText();
        String date = datapick.getValue().toString();
        System.out.println(date);

            /*  String Agents_idAgents;
    Integer patient_idpatient;
    Integer Date_idDate;
    String symptomes;
    String diagnostic;
    String traitement;
    Date dates;*/


        String query = "UPDATE consultations SET"
                + "`Agents_idAgents` =?,"
                + "`idConsultation`=?,"
                + "`symptomes`=?,"
                + "`diagnostic`=?,"
                + "`traitement`=?,"
                + "`dateConsultation`=? WHERE patient_idpatient = '"+ idPatient+"'";


        try {
            PreparedStatement prepare = connectDB.prepareStatement(query);
            prepare.setString(1,idAgent);
            prepare.setString(2,idConsultation);
            prepare.setString(3,Symptome);
            prepare.setString(4,diagnostic);
            prepare.setString(5,traitement);
            prepare.setString(6,date);


            prepare.executeUpdate();
            // Statement statement = connectDB.createStatement();
            //statement.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }
        refreshRegister();

    }

    public void delateRgister(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idConsultation  = idConsultationTextField.getText();
        String query = "DELETE FROM `consultations` WHERE idConsultation = '"+idConsultation +"'" ;
        try{
            PreparedStatement prepare = connectDB.prepareStatement(query);
            prepare.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        refreshRegister();
    }

    public void clearRegister(){
        idConsultationTextField.setText("");
        idAgentTextField.setText("");
        idpatientTextField.setText("");
        symptomeTextField.setText("");
        diagnosticTextField.setText("");
        traitementTextField.setText("");
    }

    public void searchRegisterOnAction(ActionEvent event) {
        //SELECT * FROM `patient` WHERE nomPatient = 'Fozeu'

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT * FROM `consultations` WHERE idConsultation   = '" + idConsultationTextField.getText() + "'";
        consultationModelSearchObservable.clear();
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()) {
                String queryIdAgent = queryOutput.getString("Agents_idAgents");
                Integer queryIdpatient = queryOutput.getInt("patient_idpatient");
                String queryIdSymptome = queryOutput.getString("symptomes");
                String querydiacnostic = queryOutput.getString("diagnostic");
                String querytraitement = queryOutput.getString("traitement");
                Integer queryconsultation = queryOutput.getInt("idConsultation");
                Date queryDateCons = queryOutput.getDate("dateConsultation");


                consultationModelSearchObservable.add(new searchModelConsultation(queryIdAgent, queryIdpatient, queryIdSymptome, querydiacnostic, querytraitement, queryconsultation, queryDateCons));
            }

            idAgentColum.setCellValueFactory(new PropertyValueFactory<>("Agents_idAgents"));
            idPatientColum.setCellValueFactory(new PropertyValueFactory<>("patient_idpatient"));
            idDateColum.setCellValueFactory(new PropertyValueFactory<>("symptomes"));
            idSymptometColum.setCellValueFactory(new PropertyValueFactory<>("diagnostic"));
            idDiagnostictColum.setCellValueFactory(new PropertyValueFactory<>("traitement"));
            idTraitementColum.setCellValueFactory(new PropertyValueFactory<>("idConsultation"));
            idPDateColum.setCellValueFactory(new PropertyValueFactory<>("dateConsultation"));

            tableViewElement.setItems(consultationModelSearchObservable);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreurs");
        }

    }

    public void refreshRegister(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT Agents_idAgents  ,patient_idpatient  ,symptomes , diagnostic ,traitement,idConsultation,dateConsultation FROM consultations";
        consultationModelSearchObservable.clear();
//        String PatientQuery = "SELECT * FROM `consultations` WHERE idConsultation   = '" + idConsultationTextField.getText() + "'";
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()) {
                String queryIdAgent = queryOutput.getString("Agents_idAgents");
                Integer queryIdpatient = queryOutput.getInt("patient_idpatient");
                String queryIdSymptome = queryOutput.getString("symptomes");
                String querydiacnostic = queryOutput.getString("diagnostic");
                String querytraitement = queryOutput.getString("traitement");
                Integer queryconsultation = queryOutput.getInt("idConsultation");
                Date queryDateCons = queryOutput.getDate("dateConsultation");


                consultationModelSearchObservable.add(new searchModelConsultation(queryIdAgent, queryIdpatient, queryIdSymptome, querydiacnostic, querytraitement, queryconsultation, queryDateCons));
            }

            idAgentColum.setCellValueFactory(new PropertyValueFactory<>("Agents_idAgents"));
            idPatientColum.setCellValueFactory(new PropertyValueFactory<>("patient_idpatient"));
            idDateColum.setCellValueFactory(new PropertyValueFactory<>("symptomes"));
            idSymptometColum.setCellValueFactory(new PropertyValueFactory<>("diagnostic"));
            idDiagnostictColum.setCellValueFactory(new PropertyValueFactory<>("traitement"));
            idTraitementColum.setCellValueFactory(new PropertyValueFactory<>("idConsultation"));
            idPDateColum.setCellValueFactory(new PropertyValueFactory<>("dateConsultation"));

            tableViewElement.setItems(consultationModelSearchObservable);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreurs");
        }
    }

}
