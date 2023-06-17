package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        CardView iPerfil = findViewById(R.id.iPerfil);
        CardView partidopolitico = findViewById(R.id.iPartidoPoliticos);


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
    }

}
