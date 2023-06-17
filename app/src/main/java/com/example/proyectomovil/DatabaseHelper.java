package com.example.proyectomovil;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Definir información de la base de datos
    private static final String DATABASE_NAME = "votofacil";
    private static final int DATABASE_VERSION = 1;

    private Context context;

    // Definir el nombre de la tabla

    // Sentencia SQL para crear la tabla

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public SQLiteDatabase openDatabase() {
        String dbPath = context.getDatabasePath(DATABASE_NAME).getPath();
        return SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY);
    }




}
