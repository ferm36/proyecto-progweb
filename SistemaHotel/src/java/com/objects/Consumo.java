package com.objects;

import com.connection.ConnectDB;

public class Consumo {
    private int idconsumo;
    private int idreserva;
    private int idproducto;
    private Double cantidad;
    private Double precio_venta;
    private String estado;
    private ConnectDB con = new ConnectDB();

    public Consumo() {
    }

    public int getIdconsumo() {
        return idconsumo;
    }

    public void setIdconsumo(int idconsumo) {
        this.idconsumo = idconsumo;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean insert() {
        con.executeUpdate("INSERT INTO consumo (idreserva, idproducto, cantidad, precio_venta, estado) VALUES ('"+idreserva+"','"+idproducto+"','"+cantidad+"','"+precio_venta+"','"+estado+"'");
        return true;
    }
    
    public void delete() {
        con.executeUpdate("DELETE FROM consumo WHERE idconsumo = '"+idconsumo+"'");
    }
    
    public void update() {
        con.executeUpdate("UPDATE consumo SET idreserva = '"+idreserva+"', idproducto = '"+idproducto+"', cantidad = '"+cantidad+"', precio_venta = '"+precio_venta+"', estado = '"+estado+"' WHERE idconsumo = '"+idconsumo+"';");
    }
}