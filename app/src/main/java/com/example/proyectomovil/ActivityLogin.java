package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectomovil.model.Usuario;

public class ActivityLogin extends AppCompatActivity {


    Usuario usuario;
    EditText txtcedula;
    EditText txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtcedula = (EditText) findViewById(R.id.txtcedula);
        txtpassword=(EditText) findViewById(R.id.txtpassword);

    }

    public void btnIniciarSesionOnClick(View v){
        this.getUser();
       /* if(usuario.getCedula().equals(txtcedula.getText().toString()) && usuario.getContrasena().equals(txtpassword.getText().toString())){
            Intent call_registrar = new Intent(this, ActivityInicio.class);
            startActivity(call_registrar);
        }else{
            Toast.makeText(this, "No se encuentra usuario registrado registrado", Toast.LENGTH_SHORT).show();
        }if(usuario.getCedula().equals(txtcedula.getText().toString()) || usuario.getContrasena().equals(txtpassword.getText().toString())){
            Toast.makeText(this, "Cedula o Contraseña es incorrecta", Toast.LENGTH_SHORT).show();
        }

**/
        Log.d("TAG", usuario.toString());


    }


    public void getUser() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        Intent call_Inicio = new Intent(this, ActivityInicio.class);

        if (db != null) {
            String valor = txtcedula.getText().toString();
            String vclave = txtpassword.getText().toString();
            Cursor c = null;
            usuario = new Usuario();

            try {
                c = db.rawQuery("SELECT id, cedula, nombres, apellidos, genero, edad, correo, contrasena, votacion FROM usuarios WHERE cedula = ? AND contrasena = ?", new String[]{valor, vclave});

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
                    editor.commit();

                    startActivity(call_Inicio);
                } else {
                    Toast.makeText(this, "No se encuentra registrado", Toast.LENGTH_SHORT).show();
                }
            } catch (SQLiteException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al consultar la base de datos", Toast.LENGTH_SHORT).show();
            } finally {
                if (c != null) {
                    c.close();
                }
                // db.close(); // Cerrar la base de datos si es necesario
            }
        } else {
            Toast.makeText(this, "No se pudo acceder a la base de datos", Toast.LENGTH_SHORT).show();
        }
    }






    public void btnRegistrar(View v){
        Intent call_registrar = new Intent(this, ActivityRegistroUsuario.class);
        startActivity(call_registrar);
        finish();
    }


}