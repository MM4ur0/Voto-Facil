package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class ActivityPartidosPoliticosListados extends AppCompatActivity {

    private String seleccion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos_politicos_listados);

        Spinner spinner = findViewById(R.id.spnRegion);

        ArrayList<String> regiones = new ArrayList<>();
        regiones.add("-Seleccionar-");
        regiones.add("Izquierda");
        regiones.add("Centro");
        regiones.add("Derecha");
        regiones.add("Todos");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, regiones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        CardView madera = (CardView) findViewById(R.id.derMadera);
        CardView suma = (CardView) findViewById(R.id.derSuma);
        CardView avanza = (CardView) findViewById(R.id.derAvanza);
        CardView cristiano = (CardView) findViewById(R.id.cenCristiano);
        CardView pacha = (CardView) findViewById(R.id.izqPacha);
        CardView psp = (CardView) findViewById(R.id.cenPsp);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccion = parent.getItemAtPosition(position).toString();

                if(seleccion.equals("Izquierda")){
                    madera.setVisibility(View.GONE);
                    suma.setVisibility(View.GONE);
                    avanza.setVisibility(View.GONE);
                    cristiano.setVisibility(View.GONE);
                    pacha.setVisibility(View.VISIBLE);
                    psp.setVisibility(View.GONE);
                }
                if(seleccion.equals("Derecha")){
                    madera.setVisibility(View.VISIBLE);
                    suma.setVisibility(View.VISIBLE);
                    avanza.setVisibility(View.VISIBLE);
                    cristiano.setVisibility(View.GONE);
                    pacha.setVisibility(View.GONE);
                    psp.setVisibility(View.GONE);
                }
                if(seleccion.equals("Centro")){
                    madera.setVisibility(View.GONE);
                    suma.setVisibility(View.GONE);
                    avanza.setVisibility(View.GONE);
                    cristiano.setVisibility(View.VISIBLE);
                    pacha.setVisibility(View.GONE);
                    psp.setVisibility(View.VISIBLE);
                }
                if(seleccion.equals("-Seleccionar-") || seleccion.equals("Todos")){
                    madera.setVisibility(View.VISIBLE);
                    suma.setVisibility(View.VISIBLE);
                    avanza.setVisibility(View.VISIBLE);
                    cristiano.setVisibility(View.VISIBLE);
                    pacha.setVisibility(View.VISIBLE);
                    psp.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        madera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_pp = new Intent(ActivityPartidosPoliticosListados.this, ActivityPartidoPoliticoMain.class);
                call_pp.putExtra("partido", "Madera");
                startActivity(call_pp);
            }
        });

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_pp = new Intent(ActivityPartidosPoliticosListados.this, ActivityPartidoPoliticoMain.class);
                call_pp.putExtra("partido", "Suma");
                startActivity(call_pp);
            }
        });

        avanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_pp = new Intent(ActivityPartidosPoliticosListados.this, ActivityPartidoPoliticoMain.class);
                call_pp.putExtra("partido", "Avanza");
                startActivity(call_pp);
            }
        });

        cristiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_pp = new Intent(ActivityPartidosPoliticosListados.this, ActivityPartidoPoliticoMain.class);
                call_pp.putExtra("partido", "Cristiano");
                startActivity(call_pp);
            }
        });

        pacha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_pp = new Intent(ActivityPartidosPoliticosListados.this, ActivityPartidoPoliticoMain.class);
                call_pp.putExtra("partido", "Pacha");
                startActivity(call_pp);
            }
        });

        psp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_pp = new Intent(ActivityPartidosPoliticosListados.this, ActivityPartidoPoliticoMain.class);
                call_pp.putExtra("partido", "Psp");
                startActivity(call_pp);
            }
        });

    }
}