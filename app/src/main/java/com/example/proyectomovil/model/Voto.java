package com.example.proyectomovil.model;

public class Voto {
    int id_voto;
    int papeleta_fk;
    int partido_fk;


    public Voto(int papeleta_fk, int partido_fk) {
        this.papeleta_fk = papeleta_fk;
        this.partido_fk = partido_fk;
    }

    public int getId_voto() {
        return id_voto;
    }

    public void setId_voto(int id_voto) {
        this.id_voto = id_voto;
    }

    public int getPapeleta_fk() {
        return papeleta_fk;
    }

    public void setPapeleta_fk(int papeleta_fk) {
        this.papeleta_fk = papeleta_fk;
    }

    public int getPartido_fk() {
        return partido_fk;
    }

    public void setPartido_fk(int partido_fk) {
        this.partido_fk = partido_fk;
    }
}
