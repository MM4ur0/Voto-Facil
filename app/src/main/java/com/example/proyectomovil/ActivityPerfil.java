package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ActivityPerfil extends AppCompatActivity {


    TextView tcedula;
    TextView txtnombre;
    TextView txtapellido;
    TextView genero;
    TextView edad;
    TextView correo;
    TextView votacion;
    CardView cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        tcedula = findViewById(R.id.txtced);
        txtnombre =findViewById(R.id.txtnombre);
        txtapellido=findViewById(R.id.txtapellidos);
        genero =findViewById(R.id.txtgenero);
        edad =findViewById(R.id.txtedad);
        correo =findViewById(R.id.txtCorreo);
        cd =findViewById(R.id.CVotacion);
         cd.setVisibility(View.INVISIBLE);
        this.cargarPErfil();
        Toolbar myToolbar= (Toolbar)findViewById(R.id.tooledit);
        setSupportActionBar(myToolbar);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.perfil_menu, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Aquí puedes utilizar el ID del elemento de menú para realizar acciones específicas
        if (id == R.id.edit) {
            finish();
            Intent call_log = new Intent(this, ActivityEditUser.class);
            startActivity(call_log);

            return true;
        } else if (id == R.id.logout) {
            // Acción para el segundo elemento de menú
            finish();
            Intent call_log = new Intent(this, ActivityLogin.class);
            startActivity(call_log);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cargarPErfil(){
        SharedPreferences preferences = getSharedPreferences("usuarioobj", Context.MODE_PRIVATE);
        tcedula.setText(preferences.getString("cedula",""));
        txtnombre.setText(preferences.getString("nombres",""));
        txtapellido.setText(preferences.getString("apellidos",""));
        genero.setText(preferences.getString("genero",""));
        edad.setText(preferences.getString("edad",""));
        correo.setText(preferences.getString("correo",""));
        int v = preferences.getInt("votacion",8);
        if(v==1){
            cd.setVisibility(View.VISIBLE);
        }else{
            cd.setVisibility(View.INVISIBLE);
        }


    }

    public void ok(View view){
        finish();
    }




}