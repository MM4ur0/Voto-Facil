package com.example.proyectomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityConsultarUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);
    }

    @SuppressLint("Range")
    public void btnIdentificadorOnClick(View v) {
        //DatabaseHelper dbHelper = new DatabaseHelper(this);
       /* final SQLiteDatabase db = dbHelper.getReadableDatabase();

        if (db != null) {
            EditText txtIdentificador = findViewById(R.id.txtIdentificacion);
            EditText txtApellido = findViewById(R.id.txtCApellido);
            EditText txtNombre = findViewById(R.id.txtCNombre);
            EditText txtCorreo = findViewById(R.id.txtCCorreo);
            EditText txtCedula = findViewById(R.id.txtCCedula);
            EditText txtContrasenia = findViewById(R.id.txtCContrasenia);

            String valor = txtIdentificador.getText().toString();
            Cursor c = null;

            try {
                c = db.rawQuery("SELECT id, apellido, nombre, correo, cedula, password FROM Usuario WHERE cedula = '" + valor + "'", null);

                if (c != null && c.moveToFirst()) {
                    txtApellido.setText(c.getString(c.getColumnIndex("apellido")));
                    txtNombre.setText(c.getString(c.getColumnIndex("nombre")));
                    txtCorreo.setText(c.getString(c.getColumnIndex("correo")));
                    txtCedula.setText(c.getString(c.getColumnIndex("cedula")));
                    txtContrasenia.setText(c.getString(c.getColumnIndex("password")));
                } else {
                    Toast.makeText(this, "No se encontraron registros", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al consultar la base de datos", Toast.LENGTH_SHORT).show();
            } finally {
                if (c != null) {
                    c.close();
                }
                // db.close(); // Cerrar la base de datos si es necesario
            }
        } else {
            Toast.makeText(this, "No se pudo acceder a la base de datos", Toast.LENGTH_SHORT).show();
        }
    }


    @SuppressLint("Range")
    public void btnActualizarOnClick(View v) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase(); // Abre la base de datos en modo escritura

        if (db != null) {
            EditText txtIdentificador = (EditText) findViewById(R.id.txtIdentificacion);
            EditText txtApellido = (EditText) findViewById(R.id.txtCApellido);
            EditText txtNombre = (EditText) findViewById(R.id.txtCNombre);
            EditText txtCorreo = (EditText) findViewById(R.id.txtCCorreo);
            EditText txtCedula = (EditText) findViewById(R.id.txtCCedula);
            EditText txtContrasenia = (EditText) findViewById(R.id.txtCContrasenia);

            String valor = txtIdentificador.getText().toString();
            String apellido = txtApellido.getText().toString();
            String nombre = txtNombre.getText().toString();
            String correo = txtCorreo.getText().toString();
            String cedula = txtCedula.getText().toString();
            String contrasenia = txtContrasenia.getText().toString();

            ContentValues valores = new ContentValues();
            valores.put("apellido", apellido);
            valores.put("nombre", nombre);
            valores.put("correo", correo);
            valores.put("cedula", cedula);
            valores.put("password", contrasenia);

            int filasActualizadas = db.update("Usuario", valores, "cedula=?", new String[]{valor});

            if (filasActualizadas > 0) {
                Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show();
            }

            //db.close();
        } else {
            Toast.makeText(this, "No se pudo acceder a la base de datos", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("Range")
    public void btnEliminarOnClick(View v) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        if (db != null) {
            EditText txtIdentificador = findViewById(R.id.txtIdentificacion);
            String valor = txtIdentificador.getText().toString();

            try {
                int filasEliminadas = db.delete("Usuario", "cedula=?", new String[]{valor});

                if (filasEliminadas > 0) {
                    Toast.makeText(this, "Registro eliminado correctamente", Toast.LENGTH_SHORT).show();
                    // Limpia los campos de texto después de eliminar el registro
                    txtIdentificador.setText("");
                    EditText txtApellido = findViewById(R.id.txtCApellido);
                    EditText txtNombre = findViewById(R.id.txtCNombre);
                    EditText txtCorreo = findViewById(R.id.txtCCorreo);
                    EditText txtCedula = findViewById(R.id.txtCCedula);
                    EditText txtContrasenia = findViewById(R.id.txtCContrasenia);
                    txtApellido.setText("");
                    txtNombre.setText("");
                    txtCorreo.setText("");
                    txtCedula.setText("");
                    txtContrasenia.setText("");
                } else {
                    Toast.makeText(this, "No se pudo eliminar el registro", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al eliminar el registro", Toast.LENGTH_SHORT).show();
            } finally {
                // db.close(); // Cerrar la base de datos si es necesario
            }
        } else {
            Toast.makeText(this, "No se pudo acceder a la base de datos", Toast.LENGTH_SHORT).show();
        }
    *

*/

}