package com.example.proyectomovil;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.proyectomovil.model.Usuario;

public class ActivityEditPerfil extends AppCompatActivity {
    EditText txtCedula, txtNombres, txtApellidos, txtCorreo, txtPassword, txtRPassword, txtedad;
    RadioButton masculino, femenino;

    String genero, username, userced;

    int iduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_perfil);

        txtCedula = (EditText) findViewById(R.id.tcedula);
        txtNombres = (EditText) findViewById(R.id.tnombres);
        txtApellidos = (EditText) findViewById(R.id.tapellidos);
        masculino = (RadioButton) findViewById(R.id.rbmasculino);
        femenino = (RadioButton) findViewById(R.id.rbfemenino);

        txtCorreo = (EditText) findViewById(R.id.tcorreo);
        txtPassword = (EditText) findViewById(R.id.tpassword);
        txtRPassword = (EditText) findViewById(R.id.tpassword2);
        txtedad = (EditText) findViewById(R.id.txtedad);
        this.cargarDatos();


    }


    public void cargarDatos() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();

        if (db != null) {

            SharedPreferences preferences = getSharedPreferences("usuarioobj", Context.MODE_PRIVATE);
            String valor = preferences.getString("userced", "");

            Cursor c = null;


            try {
                c = db.rawQuery("SELECT id, cedula, nombres, apellidos, genero, edad, correo, contrasena, votacion FROM usuarios WHERE cedula = ?", new String[]{valor});

                if (c != null && c.moveToFirst()) {

                    iduser=c.getInt(0);
                    txtCedula.setText(c.getString(1));
                    txtNombres.setText(c.getString(2));
                    txtApellidos.setText(c.getString(3));
                    genero=c.getString(4);

                    if (genero.equals("Masculino")){
                        masculino.setChecked(true);
                        femenino.setChecked(false);
                    }
                    else {
                        femenino.setChecked(true);
                        masculino.setChecked(false);
                    }
                    txtedad.setText(c.getString(5));
                    txtCorreo.setText(c.getString(6));
                    txtPassword.setText(c.getString(7));
                    txtRPassword.setText(c.getString(7));



                }
            } catch (SQLiteException e) {

                Toast.makeText(this, "Error al consultar la base de datos", Toast.LENGTH_SHORT).show();
            } finally {
                if (c != null) {
                    c.close();
                }
            }
        }
    }



    public void Actualizar (View view){

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



                String whereClause = "id=" + iduser;

                int filasActualizadas = db.update("Usuarios", cv, whereClause,null);

                if (filasActualizadas > 0) {
                    showConfirmationDialog();
                    Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show();
                }

                //db.close();
            } else {
                Toast.makeText(this, "No se pudo acceder a la base de datos", Toast.LENGTH_SHORT).show();
            }






            Toast.makeText(view.getContext(),"Guardado en Base de Datos",Toast.LENGTH_LONG);
        }


    }







    public void onRadioButtonClicked (View view){

        if (masculino.isChecked()==true){

            genero=masculino.getText().toString();
        }
        if (femenino.isChecked()==true){

            genero=femenino.getText().toString();
        }

    }


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
        builder.setTitle("Datos Actualizados");
        builder.setMessage("Los datos se guardaron correctamente.");

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
        Intent intent = new Intent(ActivityEditPerfil.this, ActivityPerfil.class);
        startActivity(intent);

         finish();
    }


}

