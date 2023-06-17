package com.example.proyectomovil;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Definir información de la base de datos
    private static final String DATABASE_NAME = "BDapp";
    private static final int DATABASE_VERSION = 1;

    // Definir el nombre de la tabla
    private static final String TABLE_NAME = "Usuario";

    // Sentencia SQL para crear la tabla
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +"cedula  TEXT, " +
                    "nombre  TEXT, " +
                    "apellido TEXT,"+
                    "correo TEXT,"+
                    "password TEXT"+")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla cuando se crea la base de datos por primera vez
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
