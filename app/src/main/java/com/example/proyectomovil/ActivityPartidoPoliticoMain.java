package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class ActivityPartidoPoliticoMain extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_politico_main);

        Toolbar myToolbar= (Toolbar)findViewById(R.id.PartidoPoliticoMain);
        setSupportActionBar(myToolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.partidos_politicos,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int op = item.getItemId();

        if(R.id.candidatos == op){
            Intent call_canidadtos = new Intent(this, ActivityPoliticos.class);
            startActivity(call_canidadtos);

        }else if(R.id.plan == op){
            Intent call_plan = new Intent( this, ActivityPlan.class);
            startActivity(call_plan);
        }

        return true;
    }

}