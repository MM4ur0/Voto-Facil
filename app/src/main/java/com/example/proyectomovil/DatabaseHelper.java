package com.example.proyectomovil;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_usuario = "CREATE TABLE usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT, cedula TEXT, nombres TEXT, apellidos TEXT, genero TEXT, edad TEXT, correo TEXT, contrasena TEXT);";
    private static final String TABLE_partido = "CREATE TABLE partidopolitico(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, imagen TEXT, presidente TEXT, fundacion TEXT, posicion TEXT, sede TEXT, pais TEXT);";
    private static final String TABLE_candidato = "CREATE TABLE candidato(id INTEGER PRIMARY KEY AUTOINCREMENT, imagen TEXT, nombre TEXT, cargo TEXT, partidoAfiliado TEXT);";

    private static final String TABLE_PAPELETA = "CREATE TABLE Papeleta (id_papeleta INTEGER PRIMARY KEY AUTOINCREMENT, nombre_papeleta TEXT);";

    private static final String TABLE_VOTO = "CREATE TABLE Voto (" +
            "id_voto INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "usuario_fk INTEGER, " +
            "papeleta_fk INTEGER, " +
            "partido_fk INTEGER, " +
            "FOREIGN KEY(papeleta_fk) REFERENCES Papeleta(id_papeleta) ON DELETE CASCADE, " +
            "FOREIGN KEY(partido_fk) REFERENCES partido(id_politico) ON DELETE CASCADE, " +
            "FOREIGN KEY(usuario_fk) REFERENCES Usuario(id_usuario) ON DELETE CASCADE);";


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
        db.execSQL(TABLE_PAPELETA);
        db.execSQL(TABLE_VOTO);

        String insertUsuarios = "INSERT INTO usuarios(cedula, nombres, apellidos, genero, edad, correo, contrasena) VALUES " +
                "('0931760900', 'Mauro Fabrizio', 'Ramos Mesías', 'Masculino', '24', 'framosmesias@gmail.com', '12345'), " +
                "('0912345678', 'Jesus', 'Acsota', 'Masculino', '25', 'j@gmail.com', 'j123'), " +
                "('0931760902', 'María', 'López', 'Femenino', '28', 'marialopez@gmail.com', 'qwerty')";

        db.execSQL(insertUsuarios);


        String insertPartido = "INSERT INTO partidopolitico(nombre, imagen, presidente, fundacion, posicion, sede, pais) VALUES('Partido X', 'imagen_partido.jpg', 'Juan Pérez', '01/01/2000', 'Centro', 'Ciudad A', 'País X');";
        db.execSQL(insertPartido);

        String insertCandidato = "INSERT INTO candidato(imagen, nombre, cargo, partidoAfiliado) VALUES('imagen_candidato.jpg', 'Candidato Y', 'Alcalde', 'Partido X')";
        db.execSQL(insertCandidato);

        String insertPapeleta = "INSERT INTO Papeleta (nombre_papeleta) VALUES ('Papeleta Presidencial')";
        db.execSQL(insertPapeleta);
        String insertAlcalde = "INSERT INTO Papeleta (nombre_papeleta) VALUES ('Papeleta de Alcalde')";
        db.execSQL(insertAlcalde);
        String insertAsambleistas = "INSERT INTO Papeleta (nombre_papeleta) VALUES ('Papeleta de Asambleistas')";
        db.execSQL(insertAsambleistas);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
