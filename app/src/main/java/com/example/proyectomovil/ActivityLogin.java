package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnIniciarSesionOnClick(View v){
        Intent call_Inicio = new Intent(this, ActivityInicio.class);
        startActivity(call_Inicio);
    }

    public void btnRegistrar(View v){
        Intent call_registrar = new Intent(this, ActivityRegistroUsuario.class);
        startActivity(call_registrar);
    }


}