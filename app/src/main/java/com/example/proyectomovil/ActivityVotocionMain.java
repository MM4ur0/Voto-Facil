package com.example.proyectomovil;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class ActivityVotocionMain extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votocionmain);

        Toolbar myToolbar= (Toolbar)findViewById(R.id.votomain);
        setSupportActionBar(myToolbar);

        button = findViewById(R.id.initVoto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });
    }


    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmación");
        builder.setMessage("A continuación, usted podrá acceder a las papeletas de votación y podrá elegir el candidato de su preferencia.");

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
        Intent intent = new Intent(this, ActivityPapeletaMain.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
         MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.voto_main, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Aquí puedes utilizar el ID del elemento de menú para realizar acciones específicas
        if (id == R.id.op1) {
            // Acción para el primer elemento de menú
            setContentView(R.layout.activity_faq);

            return true;
        } else if (id == R.id.op2) {
            // Acción para el segundo elemento de menú
            Intent call_partidos = new Intent(this, ActivityPartidosPoliticosListados.class);
            startActivity(call_partidos);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}