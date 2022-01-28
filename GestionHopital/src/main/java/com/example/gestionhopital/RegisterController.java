package com.example.gestionhopital;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import  javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private ImageView imagenview;
    @FXML
    private Button connection;
    @FXML
    private Button cancelButton;
    @FXML
    private Label labelsucessfuly;
    @FXML
    private PasswordField setpasswordfield;
    @FXML
    private PasswordField setconfirmpasswordfield;
    @FXML
    private Label labelcomfirmsucessfuly;
    @FXML
    private TextField MatriculeTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField surNameTextField;
    @FXML
    private TextField TelTextField;
    @FXML
    private TextField specialiteTextField;
    @FXML
    private TextField LieuTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField nomTextField;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        File imagenFile = new File("image/nurse-gf8b1afd63_1920.jpg");
        Image imagenImage = new Image(imagenFile.toURI().toString());
       imagenview.setImage(imagenImage);
    }
    public void createAccountForm() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1279, 845);
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();
        } catch (Exception e) {
            System.out.println("erreur");
        }
    }

    public void connectiOnAction(ActionEvent event) throws IOException {
        createAccountForm();
    }
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
       // Platform.exit();
    }

    public void comfirButtonOnAction(ActionEvent event){
       // labelsucessfuly.setText("user has been not created succesfully !");
        //confirRegister();
        if(setpasswordfield.getText().equals(setconfirmpasswordfield.getText())){
            confirRegister();
           // labelcomfirmsucessfuly.setText("you are set");
            //labelsucessfuly.setText("user has been  created succesfully !");
        }else{
            labelcomfirmsucessfuly.setText("passeword does not match ");
        }
    }
    public void confirRegister(){
        /*if(setpasswordfield.getText().equals(setconfirmpasswordfield.getText())){
           labelcomfirmsucessfuly.setText("you are set");
            labelsucessfuly.setText("user has been  created succesfully !");
        }else{
            labelcomfirmsucessfuly.setText("passeword does not match ");
        }*/

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstNasme = firstNameTextField.getText();
        String LastName = surNameTextField.getText();
        String nom = nomTextField.getText();
        String tel = TelTextField.getText();
        String specialite = specialiteTextField.getText();
       // String password = setpasswordfield.getText();
        String lieu = LieuTextField.getText();
        String insertField = "INSERT INTO  agents(idAgents,nomAgent,prenomAgent,telephone,specialite,lieuIntervention ) VALUES ('";
        String insertValue =  firstNasme + "','" + nom + "','" + LastName + "','" + tel + "','" + specialite + "','" + lieu + "')";

        String insertToRegister = insertField + insertValue;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
          // ResultSet queryResult = statement.executeQuery(insertField);
            labelsucessfuly.setText("user has been register sucessfully");
        }catch (Exception e){
            e.printStackTrace();
        }

        }

}
