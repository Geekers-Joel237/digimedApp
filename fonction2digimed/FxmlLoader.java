package com.example.gestionhopital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.net.URL;

public class FxmlLoader {
    @FXML
    private Pane view;


    public Pane getNpage(String fileName) throws FileNotFoundException {
        try {
            URL fileUrl = HelloApplication.class.getResource(fileName + ".fxml");
            if(fileUrl == null) {
                throw new java.io.FileNotFoundException("erreur");
            }
            view = FXMLLoader.load(fileUrl);

        }catch (Exception e){
            System.out.println("erreur");
        }
        return view ;
    }
}
