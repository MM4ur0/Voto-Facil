package com.example.proyectomovil.model;

public class Candidato {

    private  int id ;
    private  String img;
    private String nombre;
    private String cargo;
    private int idpartido;




    public Candidato(int id, String img, String nombre, String cargo, int idpartido) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
        this.cargo = cargo;
        this.idpartido = idpartido;
    }

    public Candidato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdpartido() {
        return idpartido;
    }

    public void setIdpartido(int idpartido) {
        this.idpartido = idpartido;
    }
}
