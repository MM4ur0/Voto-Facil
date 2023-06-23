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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectomovil.model.Candidato;
import com.example.proyectomovil.model.Voto;

import java.util.ArrayList;

public class ActivityPPresidentes extends AppCompatActivity {

    TextView tnp1, tnp2, tnp3, tnp4, tnp5, tnp6;
    ImageView imgp1, imgp2, imgp3, imgp4, imgp5, imgp6;
    ImageView imgv1, imgv2, imgv3, imgv4, imgv5, imgv6;
    TextView np1, np2, np3, np4, np5, np6;
    TextView nv1, nv2, nv3, nv4, nv5, nv6;
    Candidato cd;
    Voto voto;
    ArrayList<Candidato> List;
    DatabaseHelper dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppresidentes);
       cd = null;
        // Asignación de valores utilizando findViewById
        tnp1 = findViewById(R.id.tnp1);
        imgp1 = findViewById(R.id.imgp1);
        imgv1 = findViewById(R.id.imgv1);
        np1 = findViewById(R.id.np1);
        nv1 = findViewById(R.id.nv1);

        tnp2 = findViewById(R.id.tnp2);
        imgp2 = findViewById(R.id.imgp2);
        imgv2 = findViewById(R.id.imgv2);
        np2 = findViewById(R.id.np2);
        nv2 = findViewById(R.id.nv2);

        tnp3 = findViewById(R.id.tnp3);
        imgp3 = findViewById(R.id.imgp3);
        imgv3 = findViewById(R.id.imgv3);
        np3 = findViewById(R.id.np3);
        nv3 = findViewById(R.id.nv3);

        tnp4 = findViewById(R.id.tnp4);
        imgp4 = findViewById(R.id.imgp4);
        imgv4 = findViewById(R.id.imgv4);
        np4 = findViewById(R.id.np4);
        nv4 = findViewById(R.id.nv4);

        tnp5 = findViewById(R.id.tnp5);
        imgp5 = findViewById(R.id.imgp5);
        imgv5 = findViewById(R.id.imgv5);
        np5 = findViewById(R.id.np5);
        nv5 = findViewById(R.id.nv5);

        tnp6 = findViewById(R.id.tnp6);
        imgp6 = findViewById(R.id.imgp6);
        imgv6 = findViewById(R.id.imgv6);
        np6 = findViewById(R.id.np6);
        nv6 = findViewById(R.id.nv6);

        this.List= this.CargarCandidatos();
        this.Upload();
    }





    public ArrayList<Candidato> CargarCandidatos(){
        DatabaseHelper hd = new DatabaseHelper(this);
        SQLiteDatabase db = hd.getWritableDatabase();

        ArrayList<Candidato> list = new ArrayList<>();

        Cursor c = null;

        c = db.rawQuery("SELECT * FROM " + "candidato", null);

        if(c.moveToFirst()){
            do{
                cd= new Candidato();
                cd.setId(c.getInt(0));
                cd.setImg(c.getString(1));
                cd.setNombre(c.getString(2));
                cd.setCargo(c.getString(3));
                cd.setIdpartido(c.getInt(4));
                list.add(cd);
            }while (c.moveToNext());

            c.close();
        }

        return list;

    }


     public void Upload() {

         this.np1.setText(List.get(0).getNombre());
         // List<Objeto> lista = getList(); // Supongamos que tienes una lista de objetos


         np1.setText(List.get(0).getNombre());
         nv1.setText(List.get(1).getNombre());
         np2.setText(List.get(2).getNombre());
         nv2.setText(List.get(3).getNombre());
         np3.setText(List.get(4).getNombre());
         nv3.setText(List.get(5).getNombre());
         np4.setText(List.get(6).getNombre());
         nv4.setText(List.get(7).getNombre());
         /*imgp1.setText(List.get(0).getImg());
         imgv1.setText(List.get(1).getImg());
         imgp2.setText(List.get(2).getImg());
         imgv2.setText(List.get(3).getImg());
         imgp3.setText(List.get(4).getImg());
         imgv3.setText(List.get(5).getImg());
         imgp4.setText(List.get(6).getImg());
         imgv4.setText(List.get(7).getImg());
*/
/*
         int drawableId1 = getResources().getIdentifier(List.get(0).getImg(), "drawable", getPackageName());
         Drawable drawable1 = getResources().getDrawable(drawableId1);
         imgp1.setImageDrawable(drawable1);
*/

         int drawableId1 = getResources().getIdentifier(List.get(0).getImg(), "drawable", getPackageName());
         Drawable drawable1 = getResources().getDrawable(drawableId1);
         imgp1.setImageDrawable(drawable1);

         int drawableId2 = getResources().getIdentifier(List.get(1).getImg(), "drawable", getPackageName());
         Drawable drawable2 = getResources().getDrawable(drawableId2);
         imgv1.setImageDrawable(drawable2);

         int drawableId3 = getResources().getIdentifier(List.get(2).getImg(), "drawable", getPackageName());
         Drawable drawable3 = getResources().getDrawable(drawableId3);
         imgp2.setImageDrawable(drawable3);

         int drawableId4 = getResources().getIdentifier(List.get(3).getImg(), "drawable", getPackageName());
         Drawable drawable4 = getResources().getDrawable(drawableId4);
         imgv2.setImageDrawable(drawable4);

         int drawableId5 = getResources().getIdentifier(List.get(4).getImg(), "drawable", getPackageName());
         Drawable drawable5 = getResources().getDrawable(drawableId5);
         imgp3.setImageDrawable(drawable5);

         int drawableId6 = getResources().getIdentifier(List.get(5).getImg(), "drawable", getPackageName());
         Drawable drawable6 = getResources().getDrawable(drawableId6);
         imgv3.setImageDrawable(drawable6);

         int drawableId7 = getResources().getIdentifier(List.get(6).getImg(), "drawable", getPackageName());
         Drawable drawable7 = getResources().getDrawable(drawableId7);
         imgp4.setImageDrawable(drawable7);

         int drawableId8 = getResources().getIdentifier(List.get(7).getImg(), "drawable", getPackageName());
         Drawable drawable8 = getResources().getDrawable(drawableId8);
         imgv4.setImageDrawable(drawable8);


         tnp1.setText("Movimiento Madera de Guerrero");
         tnp2.setText("Sociedad Unida Más Acción");
         tnp3.setText("Partido Avanza");
         tnp4.setText("Partido Social Cristiano");
         tnp5.setText("Movimiento de Unidad Plurinacional");
         tnp6.setText("Partido Sociedad Patriótica");


     }


     public void votar(View view){
         dh= new DatabaseHelper(this);
         int botonId = view.getId();
         String idString = getResources().getResourceEntryName(botonId);
         String numeroString = idString.replaceAll("[^0-9]", ""); // Extrae solo los dígitos
         int numero = Integer.parseInt(numeroString); // Convierte el número a int

         voto = new Voto(1, numero);
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
        builder.setTitle("Realizar Votación");
        builder.setMessage(" A continuación se enviara su Voto  Y se terminara el proceso de Votar, desea continuar? ");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                guardarVoto(voto);

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