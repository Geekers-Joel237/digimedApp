package com.example.gestionhopital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class GestionHospitalisationsController implements Initializable {

    @FXML
    TextField idHospitalisationTextField;
    @FXML
    TextField DateHospitalisationTextField;
    @FXML
    TextField centreTextField;
    @FXML
    TextField motifTextField;
    @FXML
    TextField idPatientAgentTextField;
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
    private TableView<searchModelHospitalisation> tableViewElement;
    @FXML
    private TableColumn<searchModelHospitalisation,String> idHospitalisationColum;
    @FXML
    private TableColumn<searchModelHospitalisation,String> dateHospitalisationColum;
    @FXML
    private TableColumn<searchModelHospitalisation,String> centreColum;
    @FXML
    private TableColumn<searchModelHospitalisation,String> motifColum;
    @FXML
    private TableColumn<searchModelHospitalisation,String> idpatientColum;
    @FXML
    private TableColumn<searchModelHospitalisation,String> lieuColum;
    @FXML
    private TextField searchFieldLable;
    @FXML
    private Button searchButton;
    @FXML
    private DatePicker datePick;
    ObservableList<searchModelHospitalisation> patientModelSearchObservable = FXCollections.observableArrayList();

    public void initialize(URL url , ResourceBundle resourceBundle ) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT idHospitalisations ,dateHospitalisation ,centre , motif ,patient_idpatient FROM hospitalisations";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()) {
                Integer queryidHospitalisations = queryOutput.getInt("idHospitalisations");
                Date querydateHospitalisation = queryOutput.getDate("dateHospitalisation");
                String querycentre = queryOutput.getString("centre");
                String querymotif = queryOutput.getString("motif");
                Integer querypatient_idpatient = queryOutput.getInt("patient_idpatient");


                patientModelSearchObservable.add(new searchModelHospitalisation(queryidHospitalisations,querydateHospitalisation, querycentre, querymotif, querypatient_idpatient));
            }
            idHospitalisationColum.setCellValueFactory(new PropertyValueFactory<>("idHospitalisations"));
            dateHospitalisationColum.setCellValueFactory(new PropertyValueFactory<>("dateHospitalisation"));
            centreColum.setCellValueFactory(new PropertyValueFactory<>("centre"));
            motifColum.setCellValueFactory(new PropertyValueFactory<>("motif"));
            idpatientColum.setCellValueFactory(new PropertyValueFactory<>("patient_idpatient"));

           tableViewElement.setItems(patientModelSearchObservable);


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur");
        }
    }

    public void addRegister(ActionEvent event){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idHospitalisation = idHospitalisationTextField.getText();
        String centre = centreTextField.getText();
       // System.out.println(datePick.getValue().toString());
        //String date =DateHospitalisationTextField.getText();
        String date = datePick.getValue().toString();
        String motif = motifTextField.getText();
        String idpatient = idPatientAgentTextField.getText();


        String insertField = "INSERT INTO  hospitalisations(idHospitalisations ,dateHospitalisation ,centre , motif ,patient_idpatient ) VALUES ('";
        String insertValue =  idHospitalisation + "','" + date + "','" + centre + "','" + motif + "','" + idpatient + "')";
        String insertToRegister = insertField + insertValue;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void RefreshRegister(ActionEvent event){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT idHospitalisations ,dateHospitalisation ,centre , motif ,patient_idpatient FROM hospitalisations";
        patientModelSearchObservable.clear();
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()) {
                Integer queryidHospitalisations = queryOutput.getInt("idHospitalisations");
                Date querydateHospitalisation = queryOutput.getDate("dateHospitalisation");
                String querycentre = queryOutput.getString("centre");
                String querymotif = queryOutput.getString("motif");
                Integer querypatient_idpatient = queryOutput.getInt("patient_idpatient");


                patientModelSearchObservable.add(new searchModelHospitalisation(queryidHospitalisations,querydateHospitalisation, querycentre, querymotif, querypatient_idpatient));
            }
            idHospitalisationColum.setCellValueFactory(new PropertyValueFactory<>("idHospitalisations"));
            dateHospitalisationColum.setCellValueFactory(new PropertyValueFactory<>("dateHospitalisation"));
            centreColum.setCellValueFactory(new PropertyValueFactory<>("centre"));
            motifColum.setCellValueFactory(new PropertyValueFactory<>("motif"));
            idpatientColum.setCellValueFactory(new PropertyValueFactory<>("patient_idpatient"));

            tableViewElement.setItems(patientModelSearchObservable);


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur");
        }
    }

    public void updateRegister(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String idHospitalisation = idHospitalisationTextField.getText();
        String centre = centreTextField.getText();
        // System.out.println(datePick.getValue().toString());
        String date =DateHospitalisationTextField.getText();
        date = datePick.getValue().toString();
        String motif = motifTextField.getText();
        String idpatient = idPatientAgentTextField.getText();

        String query = "UPDATE hospitalisations SET"
                + "`patient_idpatient`=?,"
                + "`dateHospitalisation`=?,"
                + "`centre`=?,"
                + "`motif`=? WHERE idHospitalisations = '"+idHospitalisation+"'";

        try {
            PreparedStatement prepare = connectDB.prepareStatement(query);
            prepare.setString(1,idpatient);
            prepare.setString(2,date);
            prepare.setString(3,centre);
            prepare.setString(4,motif);

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

        String idHospitalisation  = idHospitalisationTextField.getText();
        String query = "DELETE FROM `hospitalisations` WHERE idHospitalisations = '"+idHospitalisation +"'" ;
        try{
            PreparedStatement prepare = connectDB.prepareStatement(query);
            prepare.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void searchRegisterOnAction(){
        //SELECT * FROM `patient` WHERE nomPatient = 'Fozeu'

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PatientQuery = "SELECT * FROM `hospitalisations` WHERE patient_idpatient  = '"+idPatientAgentTextField.getText()+"'" ;
        patientModelSearchObservable.clear();
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PatientQuery);

            while (queryOutput.next()){
                Integer queryidHospitalisations = queryOutput.getInt("idHospitalisations");
                Date querydateHospitalisation = queryOutput.getDate("dateHospitalisation");
                String querycentre = queryOutput.getString("centre");
                String querymotif = queryOutput.getString("motif");
                Integer querypatient_idpatient = queryOutput.getInt("patient_idpatient");


                patientModelSearchObservable.add(new searchModelHospitalisation(queryidHospitalisations,querydateHospitalisation, querycentre, querymotif, querypatient_idpatient));
            }

            idHospitalisationColum.setCellValueFactory(new PropertyValueFactory<>("idHospitalisations"));
            dateHospitalisationColum.setCellValueFactory(new PropertyValueFactory<>("dateHospitalisation"));
            centreColum.setCellValueFactory(new PropertyValueFactory<>("centre"));
            motifColum.setCellValueFactory(new PropertyValueFactory<>("motif"));
            idpatientColum.setCellValueFactory(new PropertyValueFactory<>("patient_idpatient"));

            tableViewElement.setItems(patientModelSearchObservable);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("erreur");
        }



    }

}
