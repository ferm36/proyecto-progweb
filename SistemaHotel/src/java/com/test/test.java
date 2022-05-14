package com.test;

import com.objects.Persona;

public class test {
    
    public static void main(String[] args) {
        Persona per = new Persona();
        
        per.setIdpersona(1);
        per.setNombre("Juan");
        per.setApaterno("Perez");
        per.setAmaterno("Lopez");
        per.setTipo_documento("INE");
        per.setNum_documento("881aaadd");
        per.setDomicilio("C Isla Anguila 2675, Col. Jardines de la Cruz");
        per.setCiudad("Guadalajara");
        per.setEstado("Jalisco");
        per.setPais("Mexico");
        per.setTelefono(3331);
        per.setEmail("lmoraleszapin");
        per.setRedes("AA");
        per.setRfc("MOZL010125S67");
        
        per.update();
    }
}