package com.example.proyectomovil;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.ArrayAdapter;

import com.example.proyectomovil.model.Candidato;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_USUARIO = "CREATE TABLE usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT, cedula TEXT, nombres TEXT, apellidos TEXT, genero TEXT, edad TEXT, correo TEXT, contrasena TEXT, votacion INTEGER);";
    private static final String TABLE_PARTIDO = "CREATE TABLE partidopolitico(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, imagen TEXT, fundacion TEXT, posicion TEXT, sede TEXT, pais TEXT);";
    private static final String TABLE_IDEOLOGIA = "CREATE TABLE ideologia(id INTEGER PRIMARY KEY AUTOINCREMENT, idea TEXT, idpartido TEXT);";
    private static final String TABLE_CANDIDATO = "CREATE TABLE candidato(id INTEGER PRIMARY KEY AUTOINCREMENT, imagen TEXT, nombre TEXT, cargo TEXT, idpartido TEXT);";

    private static final String TABLE_PAPELETA = "CREATE TABLE Papeleta (id_papeleta INTEGER PRIMARY KEY AUTOINCREMENT, nombre_papeleta TEXT);";

    private static final String TABLE_VOTO = "CREATE TABLE Voto (" +
            "id_voto INTEGER PRIMARY KEY AUTOINCREMENT, " +
            //"usuario_fk INTEGER, " +
            "papeleta_fk INTEGER, " +
            "partido_fk INTEGER, " +
            "FOREIGN KEY(papeleta_fk) REFERENCES Papeleta(id_papeleta) ON DELETE CASCADE, " +
            "FOREIGN KEY(partido_fk) REFERENCES partido(id_politico) ON DELETE CASCADE);";
            //"FOREIGN KEY(usuario_fk) REFERENCES Usuario(id_usuario) ON DELETE CASCADE);";

    private static final String DB_NAME = "votofacil.sqlite";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USUARIO);
        db.execSQL(TABLE_PARTIDO);
        db.execSQL(TABLE_IDEOLOGIA);
        db.execSQL(TABLE_CANDIDATO);
        db.execSQL(TABLE_PAPELETA);
        db.execSQL(TABLE_VOTO);

        String insertUsuarios = "INSERT INTO usuarios(cedula, nombres, apellidos, genero, edad, correo, contrasena,votacion) VALUES " +
                "('0931760900', 'Mauro Fabrizio', 'Ramos Mesías', 'Masculino', '24', 'framosmesias@gmail.com', '12345',0), " +
                "('0931760901', 'Jesus', 'Acosta', 'Masculino', '25', 'j@gmail.com', '12345',0), " +
                "('0931760902', 'Emely', 'Gonzalez', 'Femenino', '22', 'em@gmail.com', '12345',0)";

        db.execSQL(insertUsuarios);

        String insertPartido = "INSERT INTO partidopolitico(nombre, imagen, fundacion, posicion, sede, pais) VALUES" +
                "('Movimiento Madera de Guerrero', 'madera_guerrero', '5 de Abril de 2009', 'Derecha', 'Guayaquil', 'Ecuador' )," +
                "('Sociedad Unida Más Acción', 'suma', '15 de Mayo de 2012', 'Derecha', 'Quito', 'Ecuador')," +
                "('Partido Avanza', 'avanza', '8 de Marzo de 2012', 'Derecha', 'Quito', 'Ecuador')," +
                "('Partido Social Cristiano', 'psc', '13 de Noviembre de 1951', 'Centro', 'Quito', 'Ecuador' )," +
                "('Movimiento de Unidad Plurinacional', 'pachakutik', '1 de Noviembre de 1995', 'Izquierda','Quito', 'Ecuador')," +
                "('Partido Sociedad Patriótica', 'psp', '4 de Marzo de 2002', 'Centro', 'Quito', 'Ecuador'),"+
                "('Partido Nulo', '', 'Nulo', 'Nulo', 'Nulo', 'Nulo')";  // es para los votos en nulo
        db.execSQL(insertPartido);

        String insertarIdeologia = "INSERT INTO ideologia(idea, idpartido) VALUES" +
                "('Autonomismo', '1'), ('Liberalismo', '1'), ('Conservadurismo', '1')," +
                "('Atrapalo todo','2'), ('Liberalismo económico', '2'), ('Democracia Liberal', '2')," +
                "('Socila Democracia', '3'), ('SocioLiberalismo', '3'), ('Atrapalo todo', '3')," +
                "('Neoliberalismo', '4'), ('Democracia Cristiana', '4'), ('Conservadurismo social', '4')," +
                "('Indigenismo', '5'), ('Ecologísmo Radical', '5'), ('Plurinacionalismo', '5')," +
                "('Populismo', '6'), ('Personalismo', '6'), ('Atrapalo todo', '6');";
        db.execSQL(insertarIdeologia);


        String insertCandidato = "INSERT INTO candidato(imagen, nombre, cargo, idPartido) VALUES" +
                "('nebot', 'Jaime Nebot', 'Presidente', '1')," +
                "('cintya', 'Cinthya Vitery', 'Vise Presidente', '1')," +
                "('celi', 'Guillermo Celi', 'Preseidente', '2')," +
                "('rodas', 'Mauricio Rodas', 'Vice Presidente', '2')," +
                "('orti', 'Javier Orti', 'Presidente', '3')," +
                "('ramiro', 'Ramiro Gonzalez', 'Vice Presidente', '3')," +
                "('alfredo', 'Alfredo Serrano', 'Presidente', '4')," +
                "('juan', 'Juan Jose Yunez', 'Vise Presidente', '4')," +
                "('santi', 'Marlon Santi', 'Presidente', '5')," +
                "('cecilia', 'Cecilia Velasque', 'Vice Presidente', '5')," +
                "('lucio', 'Lucio Guttierez', 'Presidente', '6')," +
                "('ibeth', 'Ibeth Gutierrez', 'Vice Precidente', '6')";
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