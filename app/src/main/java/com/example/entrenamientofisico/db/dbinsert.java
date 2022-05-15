package com.example.entrenamientofisico.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.entrenamientofisico.activity_informes;
import com.example.entrenamientofisico.entidades.historial;
import com.example.entrenamientofisico.popupChangeImc;

import java.util.ArrayList;

public class dbinsert extends dbHelper{

    Context context;

    public dbinsert(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertRegiste(String titleEjercice){

        long id = 0;

        try {
            dbHelper dbHelp = new dbHelper(context);
            SQLiteDatabase db = dbHelp.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("titulo", titleEjercice);

            id = db.insert("t_historial", null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }

    public long insertImc(String peso, String altura, String imc){

        long id = 0;

        try {
            dbHelper dbHelp = new dbHelper(context);
            SQLiteDatabase db = dbHelp.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("peso", peso);
            values.put("altura", altura);
            values.put("imc", imc);

            id = db.insert("t_imc", null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;

    }

    public ArrayList<historial> mostrarHistorial(){
        dbHelper help = new dbHelper(context);
        SQLiteDatabase db = help.getWritableDatabase();

        ArrayList<historial> lista = new ArrayList<>();
        historial history = null;
        Cursor cursor = null;

        cursor = db.rawQuery("SELECT * FROM t_historial", null);

        if(cursor.moveToFirst()){
            do{
                history = new historial();
                history.setId(cursor.getInt(0));
                history.setTitleEjercicio(cursor.getString(1));

                lista.add(history);

            }while (cursor.moveToNext());
        }

        cursor.close();
        return lista;
    }

}
