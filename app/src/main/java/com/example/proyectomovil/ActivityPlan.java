package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        TextView plant = (TextView) findViewById(R.id.planTitulo);

        Bundle bundle_temp = this.getIntent().getExtras();
        String titulo = bundle_temp.getString("titulo");
        plant.setText(titulo);
    }
}