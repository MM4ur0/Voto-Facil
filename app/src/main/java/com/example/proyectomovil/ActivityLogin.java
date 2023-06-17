package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cedula", "0931760904");
        cv.put("nombres", "Mauro");
        cv.put("apellidos", "Ramos");
        cv.put("edad", "24");
        cv.put("correo", "fbrz@gmail.com");
        cv.put("password", "12345");
        db.insert("usuarios", null, cv);

        startActivity(call_Inicio);
    }

    public void btnRegistrar(View v){
        Intent call_registrar = new Intent(this, ActivityRegistroUsuario.class);
        startActivity(call_registrar);
    }


}