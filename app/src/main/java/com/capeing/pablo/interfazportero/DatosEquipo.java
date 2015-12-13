package com.capeing.pablo.interfazportero;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DatosEquipo extends AppCompatActivity {

    EditText etNombre, etNumTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_equipo);
        etNombre = (EditText) findViewById(R.id.editTextNombreEquipo);
        etNumTel = (EditText) findViewById(R.id.editTextNumTelEquipo);

    }

    public void guardar_datos(View v){

        BaseHelper myBaseHelper = new BaseHelper(this,"DBInterfaz",null,1);
        SQLiteDatabase db = myBaseHelper.getWritableDatabase();
        if (db !=null){
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("Nombre",etNombre.getText().toString());
            registronuevo.put("NumTel",etNumTel.getText().toString());
            if (db.insert("Equipos",null,registronuevo) > 0){
                Toast.makeText(this,"Registro Insertado Con Exito", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
