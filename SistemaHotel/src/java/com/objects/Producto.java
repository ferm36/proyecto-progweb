package com.objects;

import com.connection.ConnectDB;

public class Producto {
    private int idproducto;
    private String nombre;
    private String descripcion;
    private String unidad_medida;
    private Double precio_venta;
    private ConnectDB con = new ConnectDB();

    public Producto() {
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    public boolean insert() {
        con.executeUpdate("INSERT INTO producto (nombre, descripcion, unidad_medida, precio_venta) VALUES ('"+nombre+"','"+descripcion+"','"+unidad_medida+"','"+precio_venta+"'");
        return true;
    }
    
    public void delete() {
        con.executeUpdate("DELETE FROM producto WHERE idproducto = '"+idproducto+"'");
    }
    
    public void update() {
        con.executeUpdate("UPDATE producto SET nombre = '"+nombre+"', descripcion = '"+descripcion+"', unidad_medida = '"+unidad_medida+"', precio_venta = '"+precio_venta+"' WHERE idproducto = '"+idproducto+"';");
    }
}