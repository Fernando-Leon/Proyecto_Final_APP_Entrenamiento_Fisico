package com.example.entrenamientofisico.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NOMBRE = "historial.db";
    private static final String TABLE_HISTORIAL = "t_historial";
    private static final String TABLE_IMC = "t_imc";


    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_HISTORIAL + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL," +
                "numEjercices TEXT NOT NULL," +
                "numKcal TEXT NOT NULL)");


        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_IMC + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "peso REAL NOT NULL, " +
                "altura REAL NOT NULL, " +
                "imc REAL NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_HISTORIAL);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_IMC);
        onCreate(sqLiteDatabase);

    }
}
