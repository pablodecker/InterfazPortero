package com.capeing.pablo.interfazportero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pablo on 13/12/2015.
 */
public class BaseHelper extends SQLiteOpenHelper {

    String tabla = "CREATE TABLE EQUIPOS(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre Text, NumTel Text)";

    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
