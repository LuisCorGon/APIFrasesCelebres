package com.luiscortes.apifrasescelebres.models;

public class Frase {

    private int id;
    private String texto;
    private int idAutor;
    private int idCategoria;

    private String fechaProgramada;


    public Frase(int id, String texto, int idAutor, int idCategoria, String fechaProgramada) {
        this.id = id;
        this.texto = texto;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
        this.fechaProgramada = fechaProgramada;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getFechaProgramada() {
        return fechaProgramada;
    }

    @Override
    public String toString() {
        return "Frase{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", idAutor=" + idAutor +
                ", idCategoria=" + idCategoria +
                ", fechaProgramada='" + fechaProgramada + '\'' +
                '}';
    }
}
