package com.objects;

import java.util.Date;

import com.connection.ConnectDB;

public class Pago {
    private int idpago;
    private int idreserva;
    private String tipo_comprobante;
    private String num_comprobante;
    private Double iva;
    private Double total_pago;
    private Date fecha_emision;
    private Date fecha_pago;
    private ConnectDB con = new ConnectDB();

    public Pago() {
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getNum_comprobante() {
        return num_comprobante;
    }

    public void setNum_comprobante(String num_comprobante) {
        this.num_comprobante = num_comprobante;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(Double total_pago) {
        this.total_pago = total_pago;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    public boolean insert() {
        con.executeUpdate("INSERT INTO pago (idreserva, tipo_comprobante, num_comprobante, iva, total_pago, fecha_emision, fecha_pago) VALUES ('"+idreserva+"','"+tipo_comprobante+"','"+num_comprobante+"','"+iva+"','"+total_pago+"','"+fecha_emision+"','"+fecha_pago+"'");
        return true;
    }
    
    public void delete() {
        con.executeUpdate("DELETE FROM pago WHERE idpago = '"+idpago+"'");
    }
    
    public void update() {
        con.executeUpdate("UPDATE pago SET idreserva = '"+idreserva+"', tipo_comprobante = '"+tipo_comprobante+"', num_comprobante = '"+num_comprobante+"', iva = '"+iva+"', total_pago = '"+total_pago+"', fecha_emision = '"+fecha_emision+"', fecha_pago = '"+fecha_pago+"' WHERE idpago = '"+idpago+"';");
    }
}