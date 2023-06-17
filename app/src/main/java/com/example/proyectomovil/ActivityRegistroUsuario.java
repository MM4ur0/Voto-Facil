package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegistroUsuario extends AppCompatActivity {



    EditText txtcedula,txtnombre,txtapellido,txtcorreo,txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        txtcedula=(EditText)findViewById(R.id.txtcedula);
        txtnombre=(EditText)findViewById(R.id.txtnombre);
        txtapellido=(EditText)findViewById(R.id.txtapellido);
        txtcorreo=(EditText)findViewById(R.id.txtcorreo);
        txtpassword=(EditText)findViewById(R.id.TextPassword);


    }


public void Registrar(View view){
        SaveData(view);
    Toast.makeText(view.getContext(),"Guardado en Base de Datos",Toast.LENGTH_LONG);
}


    public void SaveData(View view){
        DatabaseHelper dbhelper = new DatabaseHelper(view.getContext());
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
        }

    }














}