package com.objects;

import java.util.Date;

import com.connection.ConnectDB;

public class Reserva {
    private int idreserva;
    private int idhabitacion;
    private int idcliente;
    private int idtrabajador;
    private String tipo_reserva;
    private Date fecha_reserva;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private Double costo_alojamiento;
    private String estado;
    private ConnectDB con = new ConnectDB();

    public Reserva() {
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Double getCosto_alojamiento() {
        return costo_alojamiento;
    }

    public void setCosto_alojamiento(Double costo_alojamiento) {
        this.costo_alojamiento = costo_alojamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean insert() {
        con.executeUpdate("INSERT INTO reserva (idhabitacion, idcliente, idtrabajador, tipo_reserva, fecha_reserva, fecha_ingreso, fecha_salida, costo_alojamiento, estado) VALUES ('"+idhabitacion+"','"+idcliente+"','"+idtrabajador+"','"+tipo_reserva+"','"+fecha_reserva+"','"+fecha_ingreso+"','"+fecha_salida+"','"+costo_alojamiento+"','"+estado+"'");
        return true;
    }
    
    public void delete() {
        con.executeUpdate("DELETE FROM reserva WHERE idreserva = '"+idreserva+"'");
    }
    
    public void update() {
        con.executeUpdate("UPDATE reserva SET idhabitacion = '"+idhabitacion+"', idcliente = '"+idtrabajador+"', tipo_reserva = '"+tipo_reserva+"', fecha_reserva = '"+fecha_reserva+"', fecha_ingreso = '"+fecha_ingreso+"', fecha_salida = '"+fecha_salida+"', costo_alojamiento = '"+costo_alojamiento+"', estado = '"+estado+"' WHERE idreserva = '"+idreserva+"';");
    }
}