package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityInicio extends AppCompatActivity {


   TextView txtced,txtname;
   String username,userced;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        CardView iPerfil = findViewById(R.id.iPerfil);
        CardView partidopolitico = findViewById(R.id.iPartidoPoliticos);
        CardView votocard = findViewById(R.id.iVotacion) ;
        CardView resultcard = findViewById(R.id.iResultado) ;
        txtced= (TextView) findViewById(R.id.txtced);
        txtname= (TextView) findViewById(R.id.txtnom);



        SharedPreferences preferences = getSharedPreferences("usuarioobj", Context.MODE_PRIVATE);


        userced =preferences.getString("userced","");
        username = preferences.getString("username","");
        txtname.setText(username);
        txtced.setText(userced);

        partidopolitico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_partidos = new Intent(ActivityInicio.this, ActivityPartidosPoliticosListados.class);
                startActivity(call_partidos);
            }
        });

        iPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_perfil = new Intent(ActivityInicio.this, ActivityPerfil.class);
                startActivity(call_perfil);
            }
        });

        votocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_voto = new Intent(ActivityInicio.this, ActivityVotocionMain.class);
                startActivity(call_voto);
            }
        });


        resultcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_re = new Intent(ActivityInicio.this, ActivityResultados.class);
                startActivity(call_re);
            }
        });



    }

}
