package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entrenamientofisico.adaptadores.listahistorialadapter;
import com.example.entrenamientofisico.db.dbHelper;
import com.example.entrenamientofisico.db.dbinsert;
import com.example.entrenamientofisico.entidades.historial;

import java.util.ArrayList;


public class activity_estadisticas extends AppCompatActivity {

    RecyclerView lista;
    ArrayList<historial> listaHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        lista = (RecyclerView) findViewById(R.id.listahistorial);

        lista.setLayoutManager(new LinearLayoutManager(this));

        dbinsert dbhistory = new dbinsert(this);

        listaHistory = new ArrayList<>();
        listahistorialadapter adapter = new listahistorialadapter(dbhistory.mostrarHistorial());

        lista.setAdapter(adapter);


        /*
        dbHelper dbHelp = new dbHelper(activity_estadisticas.this);
        SQLiteDatabase db = dbHelp.getWritableDatabase();
        if(db != null){
            Toast.makeText(this, "Base de Datos Creada", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Error al craer Base de Datos", Toast.LENGTH_LONG).show();
        */

    }

    public void statusInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void statusAjustes(View view) {
        Intent intent = new Intent(this, activity_ajustes.class);
        startActivity(intent);
    }

    public void statusInformes(View view) {
        Intent intent = new Intent(this, activity_informes.class);
        startActivity(intent);
    }


}