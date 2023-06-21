package com.example.proyectomovil;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.proyectomovil.model.Voto;

public class ActivityPapeletaMain extends AppCompatActivity {


    DatabaseHelper dh;
    CardView cardPresidente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papeleta_main);

        cardPresidente= (CardView) findViewById(R.id.cardPresidente);

        cardPresidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_pp = new Intent(ActivityPapeletaMain.this,ActivityPPresidentes.class);
                //call_pp.putExtra("partido", "1");
                startActivity(call_pp);
            }
        });
    }


    public void VNulo( View view){
          dh= new DatabaseHelper(this);

        // Crear un objeto Voto y guardar en la base de datos
        Voto voto = new Voto(1, 7);
        guardarVoto(voto);
        this.showConfirmationDialog();

    }

    private void guardarVoto(Voto voto) {
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("papeleta_fk", voto.getPapeleta_fk());
        values.put("partido_fk", voto.getPartido_fk());
        db.insert("Voto", null, values);
        db.close();
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccionar Voto Nulo");
        builder.setMessage(" A continuación se enviara su Voto como NULO Y se terminara el proceso de Votar, desea continuar? ");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                openNewActivity();
            }
        });


        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void openNewActivity() {
        SharedPreferences pe = getSharedPreferences("usuarioobj", Context.MODE_PRIVATE);
        SharedPreferences.Editor e= pe.edit();
        e.putInt("votacion",1);
        e.commit();
        Intent intent = new Intent(this, ActivityPerfil.class);


        startActivity(intent);
    }



}