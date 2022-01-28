module com.example.gestionhopital {
    requires javafx.controls;
    requires javafx.fxml;
    requires  javafx.graphics;
    requires  java.sql;
    requires  mysql.connector.java;



    opens com.example.gestionhopital to javafx.fxml;
    exports com.example.gestionhopital;
}