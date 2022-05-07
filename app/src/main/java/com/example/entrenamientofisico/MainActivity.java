package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.CharSequenceTransformation;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView fraseRandom;

    ListView categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_EntrenamientoFisico);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Genera una frase aleatoria cada que se ejecute la aplicacion

        fraseRandom = (TextView) findViewById(R.id.fraseRandom);

        String frasesRandom[] = {"Frase 1",
                                 "Frase 2",
                                 "Frase 3",
                                  "Frase 4"};

        for (int i = 0; i < 4; i++) {
            int index = (int)(Math.random() * 4);
            fraseRandom.setText(frasesRandom[index]);
        }


    }
}