package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView fraseRandom;

    private RadioGroup grupo;

    //Categoria "Abdominales"
    private RadioButton cat1nivel1;
    private RadioButton cat1nivel2;
    private RadioButton cat1nivel3;
    //Categoria "Esplada y hombros"
    private RadioButton cat2nivel1;
    private RadioButton cat2nivel2;
    private RadioButton cat2nivel3;
    //Categoria "Pecho"
    private RadioButton cat3nivel1;
    private RadioButton cat3nivel2;
    private RadioButton cat3nivel3;
    //Categoria "Brazo"
    private RadioButton cat4nivel1;
    private RadioButton cat4nivel2;
    private RadioButton cat4nivel3;
    //Categoria "Piernas"
    private RadioButton cat5nivel1;
    private RadioButton cat5nivel2;
    private RadioButton cat5nivel3;

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

        grupo = (RadioGroup) findViewById(R.id.categorias);

        cat1nivel1 = (RadioButton) findViewById(R.id.c1r1);
        cat1nivel2 = (RadioButton) findViewById(R.id.c1r2);
        cat1nivel3 = (RadioButton) findViewById(R.id.c1r3);

        cat2nivel1 = (RadioButton) findViewById(R.id.c2r1);
        cat2nivel2 = (RadioButton) findViewById(R.id.c2r2);
        cat2nivel3 = (RadioButton) findViewById(R.id.c2r3);

        cat3nivel1 = (RadioButton) findViewById(R.id.c3r1);
        cat3nivel2 = (RadioButton) findViewById(R.id.c3r2);
        cat3nivel3 = (RadioButton) findViewById(R.id.c3r3);

        cat4nivel1 = (RadioButton) findViewById(R.id.c4r1);
        cat4nivel2 = (RadioButton) findViewById(R.id.c4r2);
        cat4nivel3 = (RadioButton) findViewById(R.id.c4r3);

        cat5nivel1 = (RadioButton) findViewById(R.id.c5r1);
        cat5nivel2 = (RadioButton) findViewById(R.id.c5r2);
        cat5nivel3 = (RadioButton) findViewById(R.id.c5r3);


        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int value = 0;

                switch(i){
                    case R.id.c1r1: value = 1; break;
                    case R.id.c1r2: value = 2; break;
                    case R.id.c1r3: value = 3; break;
                    case R.id.c2r1: value = 4; break;
                    case R.id.c2r2: value = 5; break;
                    case R.id.c2r3: value = 6; break;
                    case R.id.c3r1: value = 7; break;
                    case R.id.c3r2: value = 8; break;
                    case R.id.c3r3: value = 9; break;
                    case R.id.c4r1: value = 10; break;
                    case R.id.c4r2: value = 11; break;
                    case R.id.c4r3: value = 12; break;
                    case R.id.c5r1: value = 13; break;
                    case R.id.c5r2: value = 14; break;
                    case R.id.c5r3: value = 15; break;
                }

                Bundle sendValue = new Bundle();
                sendValue.putInt("value", value);
                Intent intent = new Intent(MainActivity.this, activityExercicios.class);
                intent.putExtras(sendValue);
                startActivity(intent);
            }
        });



    }

    // menu de navegacion hacia las demas activity's

    public void statusAjustes(View view) {
        Intent intent = new Intent(this, activity_ajustes.class);
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

    //Programacion logica cada que el usuario escoje un nivel de dicha categoria


}