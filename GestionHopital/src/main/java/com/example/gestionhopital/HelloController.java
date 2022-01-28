package com.example.gestionhopital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;
import java.io.File;

public class HelloController implements Initializable {
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView ;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password ;
    @FXML
    private  Button compteButton ;
    @Override

    public void initialize(URL url , ResourceBundle resourceBundle ){
        File brandingFile = new File("image/woman-g2446c42e4_1920.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }

    public void loginButtonOnAction(ActionEvent event){

        if(username.getText().isBlank() == false &&  password.getText().isBlank()==false ){
            validLogin();

        }
        else {loginMessageLabel.setText("please enter id and passeword");}
    }

    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
    }
    public void validLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verfifylogin = "SELECT count(1) FROM agents WHERE idAgents = '" + username.getText() + "' AND telephone ='" +password.getText()+ "'";
        /*username.setText("655514455");
        password.setText("emmanuel");*/
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verfifylogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) == 1)
                {
                    loginMessageLabel.setText("congrate!!");
                    dashboardAccountForm();
                }
                else {
                    loginMessageLabel.setText("invalid connexion please try again");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void dashboardAccountForm() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1279, 845);
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();
        } catch (Exception e) {
            //System.out.println("erreur");
            e.printStackTrace();
        }
    }

    public void createAccountForm() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register1.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1279, 845);
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();
        } catch (Exception e) {
           //System.out.println("erreur");
            e.printStackTrace();
        }
    }
    /*public void createAccountForm() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("register1.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(root, 1279, 845);
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();
            //registerStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }*/
   public void suiteButtonAction(ActionEvent event)throws IOException{
        createAccountForm();
       /*Parent root = FXMLLoader.load((getClass().getResource("register.fxml")));
       Stage stage = new Stage();
       stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       Scene scene = new Scene(root, 1279, 845);
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();*/
   }

}