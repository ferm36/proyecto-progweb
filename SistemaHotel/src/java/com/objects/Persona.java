package com.objects;

import com.connection.ConnectDB;

public class Persona {
    private int idpersona;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String tipo_documento;
    private String num_documento;
    private String domicilio;
    private String ciudad;
    private String estado;
    private String pais;
    private Integer telefono;
    private String email;
    private String redes;
    private String rfc;
    private ConnectDB con = new ConnectDB();

    public Persona() {
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRedes() {
        return redes;
    }

    public void setRedes(String redes) {
        this.redes = redes;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
    public boolean insert() {
        con.executeUpdate("INSERT INTO persona (nombre, apaterno, amaterno, tipo_documento, num_documento, domicilio, ciudad, estado, pais, telefono, email, redes, rfc) VALUES ('"+nombre+"','"+apaterno+"','"+amaterno+"','"+tipo_documento+"','"+num_documento+"','"+domicilio+"','"+ciudad+"','"+estado+"','"+pais+"','"+telefono+"','"+email+"','"+redes+"','"+rfc+"'");
        return true;
    }
    
    public void delete() {
        con.executeUpdate("DELETE FROM persona WHERE idpersona = '"+idpersona+"'");
    }
    
    public void update() {
        con.executeUpdate("UPDATE persona SET nombre = '"+nombre+"', apaterno = '"+apaterno+"', amaterno = '"+amaterno+"', tipo_documento = '"+tipo_documento+"', num_documento = '"+num_documento+"', domicilio = '"+domicilio+"', ciudad = '"+ciudad+"', estado = '"+estado+"', pais = '"+pais+"', telefono = '"+telefono+"', email = '"+email+"', redes = '"+redes+"', rfc = '"+rfc+"' WHERE idpersona = '"+idpersona+"';");
    }
}