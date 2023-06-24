package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectomovil.model.Usuario;

public class ActivityLogin extends AppCompatActivity {
    Usuario usuario = new Usuario();
    EditText txtcedula;
    EditText txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtcedula = (EditText) findViewById(R.id.txtcedula);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
    }

    public void btnIniciarSesionOnClick(View v) {

        if (txtcedula.getText().toString().equals("") && txtpassword.getText().toString().equals("")) {
            Toast.makeText(this, "No ha ingresado nada", Toast.LENGTH_SHORT).show();
            return;
        }
        if (txtcedula.getText().toString().equals("")) {
            Toast.makeText(this, "No ha ingresado la cédula", Toast.LENGTH_SHORT).show();
            return;
        }
        if (txtpassword.getText().toString().equals("")) {
            Toast.makeText(this, "No ha ingresado la contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!txtcedula.getText().toString().equals("") && !txtpassword.getText().toString().equals("")) {
            this.getUser(txtcedula.getText().toString());
            if(txtcedula.getText().toString().equals(usuario.getCedula()) && txtpassword.getText().toString().equals(usuario.getContrasena())){
                Intent call_inicio = new Intent(this, ActivityInicio.class);
                startActivity(call_inicio);
                finish();
            }else{
                Toast.makeText(this, "Credenciales incorrectas!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void getUser(String identificacion) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor c = db.rawQuery("SELECT id, cedula, nombres, apellidos, genero, edad, correo, contrasena, votacion  FROM usuarios WHERE cedula=?" , new String[]{identificacion});
            if (c != null && c.moveToFirst()) {
                usuario.setId(c.getInt(0));
                usuario.setCedula(c.getString(1));
                usuario.setNombres(c.getString(2));
                usuario.setApellidos(c.getString(3));
                usuario.setGenero(c.getString(4));
                usuario.setEdad(c.getString(5));
                usuario.setCorreo(c.getString(6));
                usuario.setContrasena(c.getString(7));
                usuario.setVotacion(c.getInt(8));

                SharedPreferences preferencias = getSharedPreferences("usuarioobj", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = preferencias.edit();
                editor.putInt("id", usuario.getId());
                editor.putString("userced", usuario.getCedula());
                editor.putString("username", usuario.getNombres());
                editor.commit();
            } else {
                Toast.makeText(this, "No se pudo acceder a la base de datos", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error rawQuery", Toast.LENGTH_SHORT).show();
        }
    }


    public void btnRegistrar(View v) {
        Intent call_registrar = new Intent(this, ActivityRegistroUsuario.class);
        startActivity(call_registrar);
        finish();
    }
}