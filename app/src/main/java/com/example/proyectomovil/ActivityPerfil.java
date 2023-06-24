package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        this.cargarDatos();
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
            Intent call_log = new Intent(this, ActivityEditPerfil.class);
            startActivity(call_log);

            return true;
        } else if (id == R.id.logout) {
            // Acción para el segundo elemento de menú
            SharedPreferences preferencias = getSharedPreferences("usuarioobj",Context.MODE_PRIVATE);;
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putBoolean("Votar",false);
            editor.commit();

            finish();
            Intent call_log = new Intent(this, ActivityLogin.class);
            startActivity(call_log);

            return true;
        }

        return super.onOptionsItemSelected(item);
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

                    tcedula.setText(c.getString(1));
                    txtnombre.setText(c.getString(2));
                    txtapellido.setText(c.getString(3));
                    genero.setText(c.getString(4));
                    edad.setText(c.getString(5));
                    correo.setText(c.getString(6));
                    int v = c.getInt(8);
                    if(v==1){
                        cd.setVisibility(View.VISIBLE);
                    }else{
                        cd.setVisibility(View.INVISIBLE);
                    }

                }
            } catch (SQLiteException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al consultar la base de datos", Toast.LENGTH_SHORT).show();
            } finally {
                if (c != null) {
                    c.close();
                }
            }
        }
    }




    public void ok(View view){
        finish();

    }




}