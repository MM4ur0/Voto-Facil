package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

        CheckBox s1 = (CheckBox) findViewById(R.id.s1);
        CheckBox s2 = (CheckBox) findViewById(R.id.s2);
        CheckBox s3 = (CheckBox) findViewById(R.id.s3);
        CheckBox s4 = (CheckBox) findViewById(R.id.s4);
        CheckBox s5 = (CheckBox) findViewById(R.id.s5);

        // Agregar OnCheckedChangeListener para s1
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    s1.setButtonDrawable(R.drawable.estrellaactiva);
                    s2.setButtonDrawable(R.drawable.estrella);
                    s3.setButtonDrawable(R.drawable.estrella);
                    s4.setButtonDrawable(R.drawable.estrella);
                    s5.setButtonDrawable(R.drawable.estrella);
                } else {
                    s1.setButtonDrawable(R.drawable.estrella);
                }
            }
        });

// Agregar OnCheckedChangeListener para s2
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    s1.setButtonDrawable(R.drawable.estrellaactiva);
                    s2.setButtonDrawable(R.drawable.estrellaactiva);
                    s3.setButtonDrawable(R.drawable.estrella);
                    s4.setButtonDrawable(R.drawable.estrella);
                    s5.setButtonDrawable(R.drawable.estrella);
                } else {
                    s1.setButtonDrawable(R.drawable.estrella);
                    s2.setButtonDrawable(R.drawable.estrella);
                }
            }
        });

// Agregar OnCheckedChangeListener para s3
        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    s1.setButtonDrawable(R.drawable.estrellaactiva);
                    s2.setButtonDrawable(R.drawable.estrellaactiva);
                    s3.setButtonDrawable(R.drawable.estrellaactiva);
                    s4.setButtonDrawable(R.drawable.estrella);
                    s5.setButtonDrawable(R.drawable.estrella);
                } else {
                    s1.setButtonDrawable(R.drawable.estrella);
                    s2.setButtonDrawable(R.drawable.estrella);
                    s3.setButtonDrawable(R.drawable.estrella);
                }
            }
        });

// Agregar OnCheckedChangeListener para s4
        s4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    s1.setButtonDrawable(R.drawable.estrellaactiva);
                    s2.setButtonDrawable(R.drawable.estrellaactiva);
                    s3.setButtonDrawable(R.drawable.estrellaactiva);
                    s4.setButtonDrawable(R.drawable.estrellaactiva);
                    s5.setButtonDrawable(R.drawable.estrella);
                } else {
                    s1.setButtonDrawable(R.drawable.estrella);
                    s2.setButtonDrawable(R.drawable.estrella);
                    s3.setButtonDrawable(R.drawable.estrella);
                    s4.setButtonDrawable(R.drawable.estrella);
                }
            }
        });

// Agregar OnCheckedChangeListener para s5
        s5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    s1.setButtonDrawable(R.drawable.estrellaactiva);
                    s2.setButtonDrawable(R.drawable.estrellaactiva);
                    s3.setButtonDrawable(R.drawable.estrellaactiva);
                    s4.setButtonDrawable(R.drawable.estrellaactiva);
                    s5.setButtonDrawable(R.drawable.estrellaactiva);
                } else {
                    s1.setButtonDrawable(R.drawable.estrella);
                    s2.setButtonDrawable(R.drawable.estrella);
                    s3.setButtonDrawable(R.drawable.estrella);
                    s4.setButtonDrawable(R.drawable.estrella);
                    s5.setButtonDrawable(R.drawable.estrella);
                }
            }
        });
    }

}