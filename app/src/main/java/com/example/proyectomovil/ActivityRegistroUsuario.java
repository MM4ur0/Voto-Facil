package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityRegistroUsuario extends AppCompatActivity {

    EditText txtCedula, txtNombres, txtApellidos, txtCorreo, txtPassword, txtRPassword;
    RadioButton masculino , femenino;

    String genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txtCedula = (EditText) findViewById(R.id.txtRCedula);
        txtNombres = (EditText) findViewById(R.id.txtRnombre);
        txtApellidos = (EditText) findViewById(R.id.txtRAplleidos);
        masculino = (RadioButton) findViewById(R.id.rdbMasculino);
        femenino = (RadioButton) findViewById(R.id.rdbFemenino);
        if(masculino.isChecked()){
            genero = "Masculino";
        }else if(femenino.isChecked()){
            genero = "Femenino";
        }
        txtCorreo = (EditText) findViewById(R.id.txtRCorreo);
        txtPassword = (EditText) findViewById(R.id.txtRPassword);
        txtRPassword = (EditText) findViewById(R.id.txtRRPassword);

    }


    public void Registrar(View view){
        SaveData(view);
        Toast.makeText(view.getContext(),"Guardado en Base de Datos",Toast.LENGTH_LONG);
    }


    public void SaveData(View view){
        
        if(txtCedula.getText().toString().equals("")){
            Toast.makeText(this, "No ha llenado la cédula", Toast.LENGTH_SHORT).show();
            return;
        }

        if(txtCedula.getText().toString().length() != 10){
            Toast.makeText(this, "La cédula debe tener 10 dígitos", Toast.LENGTH_SHORT).show();
            return;
        }

        if(txtNombres.getText().toString().equals("")){
            Toast.makeText(this, "No ha completado sus nombres", Toast.LENGTH_SHORT).show();
            return;
        }

        if(txtApellidos.getText().toString().equals("")){
            Toast.makeText(this, "No ha completado sus apellidos", Toast.LENGTH_SHORT).show();
            return;
        }

        if(masculino.isChecked() == false && femenino.isChecked() == false){
            Toast.makeText(this, "No seleccionado su género", Toast.LENGTH_SHORT).show();
            return;
        }

        if(txtCorreo.getText().toString().equals("")){
            Toast.makeText(this, "No ha ingresado su correo electrónico", Toast.LENGTH_SHORT).show();
            return;
        }

        if(txtPassword.getText().toString().equals("")){
            Toast.makeText(this, "No ha ingresado una contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        if(txtRPassword.getText().toString().equals("")){
            Toast.makeText(this, "No ha repetido su contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!txtPassword.getText().toString().equals(txtRPassword.getText().toString())){
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        /*DatabaseHelper dbhelper = new DatabaseHelper(view.getContext());
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        if(db!=null){
            ContentValues cv = new ContentValues();
            cv.put("cedula",txtcedula.getText().toString());
            cv.put("nombre",txtnombre.getText().toString());
            cv.put("apellido",txtapellido.getText().toString());
            cv.put("correo",txtcorreo.getText().toString());
            cv.put("password",txtpassword.getText().toString());
            db.insert("Usuario",null,cv);
            Toast.makeText(view.getContext(),"Guardado en Base de Datos",Toast.LENGTH_LONG);
        }*/

    }














}