package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entrenamientofisico.db.dbHelper;
import com.example.entrenamientofisico.db.dbinsert;
import com.example.entrenamientofisico.entidades.historial;

import java.util.ArrayList;

public class activity_informes extends AppCompatActivity implements popupChangeImc.dialogChangeImc{

    private TextView pesoView, alturaView, imc;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informes);

        pesoView = (TextView) findViewById(R.id.valuePeso);
        alturaView = (TextView) findViewById(R.id.valueAltura);
        imc = (TextView) findViewById(R.id.resultadoImc);
        button = (Button) findViewById(R.id.abrirPopup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

            public void openDialog(){
                popupChangeImc pop = new popupChangeImc();
                pop.show(getSupportFragmentManager(), "Change Imc");
            }
        });
    }

    //Menu de navegacion

    public void statusAjustes(View view) {
        Intent intent = new Intent(this, activity_ajustes.class);
        startActivity(intent);
    }

    public void statusEstadisticas(View view) {
        Intent intent = new Intent(this, activity_estadisticas.class);
        startActivity(intent);
    }

    public void statusInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void applyTexts(String altura, String peso) {
        alturaView.setText(altura);
        pesoView.setText(peso);

        String getAltura = alturaView.getText().toString();
        String getPeso = pesoView.getText().toString();
        float floatAltura = Float.parseFloat(getAltura);
        float floatPeso = Float.parseFloat(getPeso);
        float imcResult =  floatPeso / (floatAltura * floatAltura);
        String imcString = String.valueOf(imcResult);
        imc.setText(imcString);
        registerImc();
    }

    private void registerImc(){
        dbinsert inser = new dbinsert(this);
        long id = inser.insertImc(alturaView.getText().toString(), pesoView.getText().toString(), imc.getText().toString());

        if(id > 0){
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Error al actualizar el imc", Toast.LENGTH_LONG).show();
        }

    }

}