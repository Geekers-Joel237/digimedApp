package com.example.gestionhopital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;
import java.io.File;

public class DashboardController implements  Initializable {
    @FXML
    private AnchorPane pricipale ;
    @FXML
    private Button gestionDesPatient;
    @FXML
    private Button gestionDesAgent;
    @FXML
    private Button gestionDesConsultation;
    @FXML
    private Button gestionDesHospitalisation;
    @FXML
    private Button gestionDesAntecedent;
    @FXML
    private Button quitter;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Pane view;
    @FXML
    private TabPane center;


    public void initialize(URL url , ResourceBundle resourceBundle ){
       /* File brandingFile = new File("image/woman-g2446c42e4_1920.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);*/
    }

    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) quitter.getScene().getWindow();
        stage.close();
    }
    public void gestionDP() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gestiondespatients.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1189, 785);
           // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();
        } catch (Exception e) {
            System.out.println("erreur");
        }
    }

    public Pane getNpage(String fileName) throws FileNotFoundException {

        try {

            URL fileUrl = HelloApplication.class.getResource(fileName + ".fxml");

            if(fileUrl == null) {
                throw new java.io.FileNotFoundException("erreur");
            }
            view = FXMLLoader.load(fileUrl);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            System.out.println("erreur");
        }
        return view ;
    }

    public void gestionOnAction(ActionEvent event) throws IOException {
        // gestionDP();

        System.out.println("click me");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getNpage("gestiondespatients");
       mainPane.setCenter(view);
    }

    public void gestionAG() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gestiondesagents.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            // registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();
        } catch (Exception e) {
            System.out.println("erreur");
        }
    }

    public void gestionAgOnAction(ActionEvent event) throws IOException {
       // gestionAG();

        System.out.println("click me");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getNpage("gestiondesagents");
        mainPane.setCenter(view);
    }

    public void hospitalisationOnAction(ActionEvent event)throws IOException{

        System.out.println("click me");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getNpage("hospitalisations");
        mainPane.setCenter(view);
    }

    public void antecedentOnAction(ActionEvent event)throws IOException{

        System.out.println("click me");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getNpage("antecedants");
        mainPane.setCenter(view);
    }

    public void consultationOnAction(ActionEvent event)throws IOException{

        System.out.println("click me");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getNpage("consultations");
        mainPane.setCenter(view);

//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("consultations.fxml"));
//            Stage registerStage = new Stage();
//            Scene scene = new Scene(fxmlLoader.load());
//            // registerStage.initStyle(StageStyle.UNDECORATED);
//            registerStage.setScene(scene);
//            registerStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("erreursss");
//        }
    }



}
