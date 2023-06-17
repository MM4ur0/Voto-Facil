package com.example.proyectomovil;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_usuario = "CREATE TABLE usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT, cedula TEXT, nombres TEXT, apellidos TEXT, genero TEXT, edad TEXT, correo TEXT, contrasena TEXT);";
    private static final String TABLE_partido = "CREATE TABLE partidopolitico(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, imagen TEXT, presidente TEXT, fundacion TEXT, posicion TEXT, sede TEXT, pais TEXT);";
    private static final String TABLE_candidato = "CREATE TABLE candidato(id INTEGER PRIMARY KEY AUTOINCREMENT, imagen TEXT, nombre TEXT, cargo TEXT, partidoAfiliado TEXT);";

    /*
    *
    * */


    private static final String DB_NAME = "votofacil.sqlite";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_usuario);
        db.execSQL(TABLE_partido);
        db.execSQL(TABLE_candidato);
        String insertUsuario = "INSERT INTO usuarios(cedula, nombres, apellidos, genero, edad, correo, contrasena) VALUES('0931760900', 'Mauro Fabrizio', 'Ramos Mesías', 'Masculino', '24', 'framosmesias@gmail.com', '12345')";
        db.execSQL(insertUsuario);

        String insertPartido = "INSERT INTO partidopolitico(nombre, imagen, presidente, fundacion, posicion, sede, pais) VALUES('Partido X', 'imagen_partido.jpg', 'Juan Pérez', '01/01/2000', 'Centro', 'Ciudad A', 'País X');";
        db.execSQL(insertPartido);

        String insertCandidato = "INSERT INTO candidato(imagen, nombre, cargo, partidoAfiliado) VALUES('imagen_candidato.jpg', 'Candidato Y', 'Alcalde', 'Partido X')";
        db.execSQL(insertCandidato);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
