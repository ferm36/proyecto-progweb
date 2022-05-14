package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConnectDB {
    private Connection con = null;
    private String url = "";
    
    public ConnectDB(String url) {
        try {
            this.url = url;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url);
            System.out.println("Conexión establecida con éxito.");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getCause());
        }
    }
    
    public ConnectDB() {
        try {
            this.url = url;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url);
            System.out.println("Conexión establecida con éxito.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getCause());
        }
    }
    
    public Connection getCon() {
        return con;
    }
    
    public void executeUpdate(String sql) {
        try {
            PreparedStatement ps = (PreparedStatement) this.getCon().prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Ejecutado con éxito.");
        } catch (Exception e) {
            System.out.println("Error en la ejecución: " + e.getCause());
        }
    }
    
    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = (PreparedStatement) this.getCon().prepareStatement(sql);
            rs = (ResultSet) ps.executeQuery();
            System.out.println("Ejecutado con éxito.");
        } catch (Exception e) {
            System.out.println("Error en la ejecución: " + e.getCause());
        }
        return rs;
    }
    
    public Connection closeConnection() {
        try {
            con.close();
            System.out.println("Conexión cerrada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error cerrando la conexión: " + e.getCause());
        }
        con = null;
        return con;
    }
}