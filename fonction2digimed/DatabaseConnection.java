package com.example.gestionhopital;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection databeLink;
    public Connection getConnection() {

        String databaseName = "digimeddatabase2";
        String databaseUser = "root";
        String databsePasseword = "";
        String url = "jdbc:mysql://localhost:3306/"+databaseName;

     try{
        Class.forName("com.mysql.jdbc.Driver");
        databeLink = DriverManager.getConnection(url,databaseUser,databsePasseword);
    }catch(Exception ex){
        ex.printStackTrace();
        ex.getCause();
    }
     return databeLink;
    }
}






