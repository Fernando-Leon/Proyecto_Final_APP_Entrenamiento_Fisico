package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activityExercicios extends AppCompatActivity {

    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

        titulo = (TextView) findViewById(R.id.tituloEjercicio);

        Bundle getValue = getIntent().getExtras();
        int valueCat = getValue.getInt("value");

        String indexTitle[] = {
                "Abdominales - pricipiante",
                "Abdominales - intermedio",
                "Abdominales - avanzado",
                "Espalda y hombros - pricipiante",
                "Espalda y hombros - intermedio",
                "Espalda y hombros - avanzado",
                "Pecho - pricipiante",
                "Pecho - intermedio",
                "Pecho - avanzado",
                "Brazo - pricipiante",
                "Brazo - intermedio",
                "Brazo - avanzado",
                "Pierna - pricipiante",
                "Peirna - intermedio",
                "Pierna - avanzado"
        };

        for(int i=1; i<=15; i+=1) {
            if(valueCat == i){
                titulo.setText(indexTitle[i-1]);
            }
        }
    }
}