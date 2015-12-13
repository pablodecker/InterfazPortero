package com.capeing.pablo.interfazportero;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargar_datos();
    }

    public void agregar_equipo(View v)
    {
        Intent i = new Intent(MainActivity.this , DatosEquipo.class );
        startActivity(i);
    }
    public void cargar_datos(){

        BaseHelper myBaseHelper = new BaseHelper(this,"DBInterfaz",null,1);
        SQLiteDatabase db = myBaseHelper.getReadableDatabase();
        if (db !=null){
            Cursor c =  db.rawQuery("SELECT * FROM Equipos",null);
            int cantidad = c.getCount();
            String[] stArreglo = new String[cantidad];
            int i = 0;
            if (c.moveToFirst()){
                do{
//                    String stDato = c.getInt(0) + " " + c.getString(0) + c.getInt(1) + " " + c.getString(1);
                    String stDato = c.getString(1) +  " " + c.getString(2);
                    stArreglo[i++] = stDato;
                }while (c.moveToNext());
            }
            //Creo un adapter para despues setearselo a la lista
            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stArreglo);
            ListView lista = (ListView)findViewById(R.id.listViewListaEquipos);
            lista.setAdapter(adapter);
        }
    }


}
