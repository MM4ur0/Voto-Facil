package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

public class ActivityPartidoPoliticoMain extends AppCompatActivity {

    String nombrePartido, idPartido, imgPartido;
    @SuppressLint("Range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_politico_main);

        Toolbar myToolbar= (Toolbar)findViewById(R.id.PartidoPoliticoMain);
        setSupportActionBar(myToolbar);

        Bundle bundle_temp = this.getIntent().getExtras();
        int identificador = Integer.parseInt(bundle_temp.getString("partido"));

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        if(db != null){

            TextView titulo = (TextView) findViewById(R.id.infoTitulo);

            ImageView img = (ImageView) findViewById(R.id.infoImg);
            TextView ano = (TextView) findViewById(R.id.infoAno);
            TextView sede = (TextView) findViewById(R.id.infoSede);
            TextView pais = (TextView) findViewById(R.id.infoPais);
            TextView posicion = (TextView) findViewById(R.id.infoPosicion);
            Cursor c = db.rawQuery("SELECT id, nombre, imagen, fundacion, posicion, sede, pais FROM partidopolitico WHERE id="+identificador, null);
            if( c!= null){
                c.moveToFirst();
                idPartido = c.getString(c.getColumnIndex("id"));
                titulo.setText(c.getString(c.getColumnIndex("nombre")));
                nombrePartido = c.getString(c.getColumnIndex("nombre"));
                imgPartido = c.getString(c.getColumnIndex("imagen"));
                int drawableId = getResources().getIdentifier(imgPartido, "drawable", getPackageName());
                Drawable drawable = getResources().getDrawable(drawableId);
                img.setImageDrawable(drawable);

                ano.setText(c.getString(c.getColumnIndex("fundacion")));
                sede.setText(c.getString(c.getColumnIndex("sede")));
                pais.setText(c.getString(c.getColumnIndex("pais")));
                posicion.setText(c.getString(c.getColumnIndex("posicion")));
            }
            c.close();
        }
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
            call_canidadtos.putExtra("titulo", nombrePartido);
            call_canidadtos.putExtra("id", idPartido);
            call_canidadtos.putExtra("img", imgPartido);
            startActivity(call_canidadtos);

        }else if(R.id.plan == op){
            Intent call_plan = new Intent( this, ActivityPlan.class);
            call_plan.putExtra("titulo", nombrePartido);
            call_plan.putExtra("id", idPartido);
            startActivity(call_plan);
        }

        return true;
    }

}