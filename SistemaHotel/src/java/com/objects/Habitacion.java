package com.objects;

import com.connection.ConnectDB;

public class Habitacion {
    private int idhabitacion;
    private String numero;
    private String piso;
    private String descripcion;
    private String caracteristicas;
    private Double precio_diario;
    private String estado;
    private String tipo_habitacion;
    
    private ConnectDB con = new ConnectDB();

    public Habitacion() {
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPrecio_diario() {
        return precio_diario;
    }

    public void setPrecio_diario(Double precio_diario) {
        this.precio_diario = precio_diario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(String tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }
    
    public boolean insert() {
        con.executeUpdate("INSERT INTO habitacion (numero, piso, descripcion, caracteristicas, precio_diario, estado, tipo_habitacion) VALUES ('"+numero+"','"+piso+"','"+descripcion+"','"+caracteristicas+"','"+precio_diario+"','"+estado+"','"+tipo_habitacion+"'");
        return true;
    }
    
    public void delete() {
        con.executeUpdate("DELETE FROM habitacion WHERE idhabitacion = '"+idhabitacion+"'");
    }
    
    public void update() {
        con.executeUpdate("UPDATE habitacion SET numero = '"+numero+"', piso = '"+piso+"', descripcion = '"+descripcion+"', caracteristicas = '"+caracteristicas+"', precio_diario = '"+precio_diario+"', estado = '"+estado+"', tipo_habitacion = '"+tipo_habitacion+"' WHERE idhabitacion = '"+idhabitacion+"';");
    }
}