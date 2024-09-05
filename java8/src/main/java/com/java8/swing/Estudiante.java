package com.java8.swing;

public class Estudiante {
    private String nombres;
    private String rut;
    private String email;

    public Estudiante(String rut, String nombres,String email) {
        this.nombres = nombres;
        this.rut = rut;
        this.email = email;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
