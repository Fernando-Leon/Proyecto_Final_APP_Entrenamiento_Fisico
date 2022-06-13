package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.entrenamientofisico.db.dbHelper;
import com.example.entrenamientofisico.db.dbinsert;

public class activity_ajustes extends AppCompatActivity {

    private Button exit, deleteHistory, viewAvisos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        deleteHistory = (Button) findViewById(R.id.deleteHistorial);
        exit = (Button) findViewById(R.id.exitAplication);
        viewAvisos = (Button) findViewById(R.id.viewPolices);


        viewAvisos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAvisos();
            }
        });

        deleteHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }

        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitApp();
            }
        });
    }

    private void delete() {
        new AlertDialog.Builder(this)
                .setTitle("Elimniar historial")
                .setMessage("Desea eliminar el historial?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteTable();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    private void exitApp() {
        new AlertDialog.Builder(this)
                .setTitle("Salir de la aplicacion")
                .setMessage("Desea salir de la aplicacion?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    //Menu de navegacion

    public void statusInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void statusEstadisticas(View view) {
        Intent intent = new Intent(this, activity_estadisticas.class);
        startActivity(intent);
    }

    public void statusInformes(View view) {
        Intent intent = new Intent(this, activity_informes.class);
        startActivity(intent);
    }

    //Metodo para eliminar los registros de la tabal historial

    private void deleteTable(){
        dbinsert deleted = new dbinsert(activity_ajustes.this);

        SQLiteDatabase db = deleted.getWritableDatabase();

        try{
            db.execSQL("DELETE FROM t_historial");
            db.execSQL("DELETE FROM t_imc");
        } catch (Exception ex){
            ex.toString();
        } finally {
            db.close();
        }
    }

    private void showAvisos(){
        Intent intent = new Intent(this, avisos.class);
        startActivity(intent);
    }
}