package com.example.proyectomovil.model;

public class Usuario {
    private int id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String genero;
    private String edad;
    private String correo;
    private String contrasena;

    private int votacion;

    public Usuario() {
    }

    public Usuario(int id, String cedula, String nombres, String apellidos, String genero, String edad, String correo, String contrasena, int votacion) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.edad = edad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.votacion = votacion;
    }

    // Getters y Setters


    public int getVotacion() {
        return votacion;
    }

    public void setVotacion(int votacion) {
        this.votacion = votacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método toString()

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", genero='" + genero + '\'' +
                ", edad='" + edad + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
