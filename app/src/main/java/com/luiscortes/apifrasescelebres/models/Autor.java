package com.luiscortes.apifrasescelebres.models;

public class Autor {

    private int id;
    private String nombre;
    private String nacimiento;
    private String muerte;
    private String profesion;

    public Autor(int id, String nombre, String nacimiento, String muerte, String profesion) {
        this.id = id;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.muerte = muerte;
        this.profesion = profesion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getMuerte() {
        return muerte;
    }

    public String getProfesion() {
        return profesion;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacimiento='" + nacimiento + '\'' +
                ", muerte='" + muerte + '\'' +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}
