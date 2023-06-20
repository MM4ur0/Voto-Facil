package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
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

        ImageButton btn = (ImageButton) findViewById(R.id.btnPdf);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        CheckBox s1 = (CheckBox) findViewById(R.id.s1);
        CheckBox s2 = (CheckBox) findViewById(R.id.s2);
        CheckBox s3 = (CheckBox) findViewById(R.id.s3);
        CheckBox s4 = (CheckBox) findViewById(R.id.s4);
        CheckBox s5 = (CheckBox) findViewById(R.id.s5);

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
                    s2.setButtonDrawable(R.drawable.estrella);
                    s3.setButtonDrawable(R.drawable.estrella);
                    s4.setButtonDrawable(R.drawable.estrella);
                    s5.setButtonDrawable(R.drawable.estrella);
                }
            }
        });

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
                    s3.setButtonDrawable(R.drawable.estrella);
                    s4.setButtonDrawable(R.drawable.estrella);
                    s5.setButtonDrawable(R.drawable.estrella);
                }
            }
        });

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
                    s4.setButtonDrawable(R.drawable.estrella);
                    s5.setButtonDrawable(R.drawable.estrella);
                }
            }
        });

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
                    s5.setButtonDrawable(R.drawable.estrella);
                }
            }
        });

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