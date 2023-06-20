package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityComentarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);
    }

    public void btnComentarOnClick(View v){
        LinearLayout cCard = (LinearLayout) findViewById(R.id.cCard);
        EditText comentario = (EditText)  findViewById(R.id.txtMultiLine);
        TextView cRealizado = (TextView) findViewById(R.id.cRealizado);
        if(comentario.getText().toString().equals("")){
            Toast.makeText(this, "No ha escrito nada", Toast.LENGTH_SHORT).show();
        }else{
            cRealizado.setText(comentario.getText().toString());
            comentario.setText("");
            cCard.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Se ha realizado el comentario", Toast.LENGTH_SHORT).show();
        }
    }
}