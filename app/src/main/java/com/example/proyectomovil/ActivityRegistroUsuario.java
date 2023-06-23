package com.example.proyectomovil;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityRegistroUsuario extends AppCompatActivity {

    EditText txtCedula, txtNombres, txtApellidos, txtCorreo, txtPassword, txtRPassword,txtedad;
    RadioButton masculino , femenino;

    String genero,username,userced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txtCedula = (EditText) findViewById(R.id.txtRCedula);
        txtNombres = (EditText) findViewById(R.id.txtRnombre);
        txtApellidos = (EditText) findViewById(R.id.txtRAplleidos);
        masculino = (RadioButton) findViewById(R.id.rdbMasculino);
        femenino = (RadioButton) findViewById(R.id.rdbFemenino);
        /*if(masculino.isChecked()){
            genero = "Masculino";
        }else if(femenino.isChecked()){
            genero = "Femenino";
        }*/
        txtCorreo = (EditText) findViewById(R.id.txtRCorreo);
        txtPassword = (EditText) findViewById(R.id.txtRPassword);
        txtRPassword = (EditText) findViewById(R.id.txtRRPassword);
        txtedad = (EditText) findViewById(R.id.txtedad);
    }


    public void Registrar(View view){

        if(SaveData(view)){
            DatabaseHelper dbhelper = new DatabaseHelper(view.getContext());
            SQLiteDatabase db = dbhelper.getWritableDatabase();
                if(db!=null){
                    //usuarios(cedula, nombres, apellidos, genero, edad, correo, contrasena,votacion)
                    ContentValues cv = new ContentValues();
                    cv.put("cedula",txtCedula.getText().toString());
                    cv.put("nombres",txtNombres.getText().toString());
                    cv.put("apellidos",txtApellidos.getText().toString());
                    cv.put("genero",genero);
                    cv.put("edad",txtedad.getText().toString());
                    cv.put("correo",txtCorreo.getText().toString());
                    cv.put("contrasena",txtPassword.getText().toString());
                    userced= txtCedula.getText().toString();
                    username=txtNombres.getText().toString() + txtApellidos.getText().toString();


                    SharedPreferences preferencias = getSharedPreferences("usuarioobj", Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = preferencias.edit();

                    editor.putString("userced", userced);
                    editor.putString("username",username);
                    editor.commit();





                    db.insert("usuarios",null,cv);
                    Toast.makeText(view.getContext(),"Guardado en Base de Datos",Toast.LENGTH_LONG);
                }

            showConfirmationDialog();
        }



        //Toast.makeText(view.getContext(),"Guardado en Base de Datos",Toast.LENGTH_LONG);
    }



    public void onRadioButtonClicked (View view){

        if (masculino.isChecked()==true){

            genero=masculino.getText().toString();
        }
        if (femenino.isChecked()==true){

            genero=femenino.getText().toString();
        }

    }

    public void No(View view){}

    public boolean SaveData(View view){
        
        if(txtCedula.getText().toString().equals("")){
            Toast.makeText(this, "No ha llenado la cédula", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txtCedula.getText().toString().length() != 10){
            Toast.makeText(this, "La cédula debe tener 10 dígitos", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txtNombres.getText().toString().equals("")){
            Toast.makeText(this, "No ha completado sus nombres", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txtApellidos.getText().toString().equals("")){
            Toast.makeText(this, "No ha completado sus apellidos", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(masculino.isChecked() == false && femenino.isChecked() == false){
            Toast.makeText(this, "No seleccionado su género", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txtCorreo.getText().toString().equals("")){
            Toast.makeText(this, "No ha ingresado su correo electrónico", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txtPassword.getText().toString().equals("")){
            Toast.makeText(this, "No ha ingresado una contraseña", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txtRPassword.getText().toString().equals("")){
            Toast.makeText(this, "No ha repetido su contraseña", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!txtPassword.getText().toString().equals(txtRPassword.getText().toString())){
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Usuario Registrado");
        builder.setMessage("Registro Exitoso.");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                openNewActivity();
            }
        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

    private void openNewActivity() {
        Intent intent = new Intent(this, ActivityInicio.class);
        startActivity(intent);



    }












}