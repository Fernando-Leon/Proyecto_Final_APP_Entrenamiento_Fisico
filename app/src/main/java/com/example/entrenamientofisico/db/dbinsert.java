package com.example.entrenamientofisico.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.entrenamientofisico.entidades.historial;

import java.util.ArrayList;

public class dbinsert extends dbHelper{

    Context context;

    public dbinsert(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertRegiste(String titleEjercice, String numEjercicios, String numCalorias){

        long id = 0;

        try {
            dbHelper dbHelp = new dbHelper(context);
            SQLiteDatabase db = dbHelp.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("titulo", titleEjercice);
            values.put("numEjercices", numEjercicios);
            values.put("numKcal", numCalorias);


            id = db.insert("t_historial", null, values);
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
                history.setEjercicios(cursor.getString(2));
                history.setKcal(cursor.getString(3));

                lista.add(history);

            }while (cursor.moveToNext());
        }

        cursor.close();
        return lista;
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

    public historial verImc(){
        dbHelper help = new dbHelper(context);
        SQLiteDatabase db = help.getWritableDatabase();


        historial history = null;
        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM t_imc WHERE id = (SELECT MAX(id) FROM t_imc);", null);

        if(cursor.moveToFirst()){
            history = new historial();
            history.setPeso(cursor.getString(1));
            history.setAltura(cursor.getString(2));
            history.setImc(cursor.getString(3));
        }

        cursor.close();

        return history;
    }


}
