package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityPoliticos extends AppCompatActivity {
    String titulop, id, img, img2;
    @Override
    @SuppressLint("Range")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politicos);

        Bundle bundle_temp = this.getIntent().getExtras();
        id =bundle_temp.getString("id");
        titulop = bundle_temp.getString("titulo");
        img = bundle_temp.getString("img");
        ImageView imgpoliticos = (ImageView) findViewById(R.id.politicosImg);
        int drawableId = getResources().getIdentifier(img, "drawable", getPackageName());
        Drawable drawable = getResources().getDrawable(drawableId);
        imgpoliticos.setImageDrawable(drawable);
        TextView titulo = (TextView) findViewById(R.id.politicosTitulo);
        titulo.setText(titulop);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        final SQLiteDatabase db = dbHelper.getReadableDatabase();
        if(db != null){
            TextView presidente = (TextView) findViewById(R.id.pPresidente);
            ImageView imgpresidente = (ImageView) findViewById(R.id.pPresidenteImg);
            ImageView imgvice = (ImageView) findViewById(R.id.pViceImg);
            TextView vice = (TextView) findViewById(R.id.pVice);

            Cursor c = db.rawQuery("SELECT nombre, imagen FROM candidato WHERE idPartido = "+id, null);
            if(c!=null){
                c.moveToFirst();
                presidente.setText(c.getString(c.getColumnIndex("nombre")));
                img2 = c.getString(c.getColumnIndex("imagen"));
                int imgId = getResources().getIdentifier(img2, "drawable", getPackageName());
                Drawable drawable2 = getResources().getDrawable(imgId);
                imgpresidente.setImageDrawable(drawable2);
                if (c.moveToPosition(1)) { // Mover al siguiente registro
                    img2 = c.getString(c.getColumnIndex("imagen"));
                    imgId = getResources().getIdentifier(img2, "drawable", getPackageName());
                    drawable2 = getResources().getDrawable(imgId);
                    imgvice.setImageDrawable(drawable2);
                    vice.setText(c.getString(c.getColumnIndex("nombre")));
                }
            }
        }
    }
}