/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sayid, majd
 */
public class PostgreConnector {
    private final  String database_connection_string = "jdbc:postgresql://localhost:5432/*****";
    private final  String database_user_name = "postgres";
    private final  String database_user_password = "*****";
    private Connection  conn;
 
    public Connection connectorSender() {
        try {
            
            conn = DriverManager.getConnection(database_connection_string, database_user_name, database_user_password );
            System.out.println("You are successfully connected to the PostgreSQL database server.");
            
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println("Exception");
        }
        return conn;
    }
    
    public Connection getInstance(){
        if(conn == null){
            System.out.println("Test");
            conn = connectorSender();
        }
        return conn;
    }
}
