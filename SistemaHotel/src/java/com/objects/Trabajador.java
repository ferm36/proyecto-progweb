package com.objects;

import com.connection.ConnectDB;

public class Trabajador {
    private int idpersona;
    private Double sueldo;
    private String acceso;
    private String usuario;
    private String contrasena;
    private int estado;
    
    private ConnectDB con = new ConnectDB();

    public Trabajador() {
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public boolean insert() {
        con.executeUpdate("INSERT INTO trabajador VALUES ('"+idpersona+"','"+sueldo+"','"+acceso+"','"+usuario+"','"+contrasena+"','"+estado+"'");
        return true;
    }
    
    public void delete() {
        con.executeUpdate("DELETE FROM trabajador WHERE idpersona = '"+idpersona+"'");
    }
    
    public void update() {
        con.executeUpdate("UPDATE trabajador SET sueldo = '"+sueldo+"', acceso = '"+acceso+"', usuario = '"+usuario+"', contrasena = '"+contrasena+"', estado = '"+estado+"' WHERE idpersona = '"+idpersona+"';");
    }
}