package com.objects;

import com.connection.ConnectDB;

public class Cliente {
    private int idpersona;
    private String codigo_cliente;
    private ConnectDB con = new ConnectDB();

    public Cliente() {
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
    public boolean insert() {
        con.executeUpdate("INSERT INTO cliente VALUES ('"+idpersona+"','"+codigo_cliente+"'");
        return true;
    }
    
    public void delete() {
        con.executeUpdate("DELETE FROM cliente WHERE codigo_cliente = '"+codigo_cliente+"'");
    }
    
    public void update() {
        con.executeUpdate("UPDATE cliente SET codigo_cliente = '"+codigo_cliente+"' WHERE idpersona = '"+idpersona+"';");
    }
}
