package com.codoacodo.ejerciciojunit.classes;

public class Usuario {

    private String nombre;
    private String apellido;

    //Constructor por defecto:
    public Usuario() {}

    //Constructor con parámetros:
    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getters & Setters:
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Método toString:
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Apellido: " + this.apellido;
    }
}
