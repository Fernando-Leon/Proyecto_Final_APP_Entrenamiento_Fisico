package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activityExercicios extends AppCompatActivity {

    private TextView titulo;
    private TextView descripcion;
    private TextView tituloEjercicio;
    private Button botonRecorrer;
    int numEjercicio = 1;
    int countLevel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

        titulo = (TextView) findViewById(R.id.tituloEjercicio);
        tituloEjercicio = (TextView) findViewById(R.id.nombreEjercicio);
        descripcion = (TextView) findViewById(R.id.descripcionEjercicio);

        Bundle getValue = getIntent().getExtras();
        int valueCat = getValue.getInt("value");
        int numCategoria = valueCat;

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

        String abdominales[][] = {
                {"Salto de tijera", "Comienza con los pies juntos y los brazos a los lados."},
                {"Crunch abdominales", "Tumbate oca arriba con las rodillas flexionadas y los brazos xtendidos hacia adelante."}
        };

        String espaldaHombros[][] = {
                {"Tracciones de romboides","Colocate de pie y con los pies alineados con los hombros."},
                {"Flexiones con apoyo en las rodillas","Comienza en posicion de flexion con las rodiilas tocando el suelo."}
        };

        String pecho[][] = {
                {"Flexiones","Suba y baje el cuerpo con los dos brazos mantenga en cuerpo recto."},
                {"Esiramiento de cobra","Tumbate boca abajo, dobla los codos y coloca las manos por debajo de los hombros"}
        };

        String brazo[][] = {
                {"Plancha diagonal","Comienza en posicion de plancha. Eleva el brazo derecho y la pierna izquierda en paralelo con el suelo."},
                {"Saltos con cuerda","Coloca los brazos a los lados toma la cuerda y empieza a brincar."}
        };

        String pierna[][] = {
                {"Salto lateral","De pie, coloca las manos frenrte a ti y salta de un lado a otro."},
                {"Squats","De pie, con los pies alineados con los hombros y los brazos estirados hacia adelante."}
        };

        int level2 = 2;


        for(int i=1; i<=15; i+=1) {
            if(valueCat == i){
                titulo.setText(indexTitle[i-1]);
            }
        }

        botonRecorrer = (Button) findViewById(R.id.siguiente);

        botonRecorrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(valueCat == 2){
                    tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                    descripcion.setText(abdominales[numEjercicio-1][1]);

                    if(numEjercicio < abdominales.length){
                        numEjercicio++;
                    }else if(numEjercicio == abdominales.length){
                        countLevel++;
                        if(countLevel <= level2){
                            numEjercicio=1;
                        }
                    }
                }


                else if(valueCat == 4 || valueCat == 5 || valueCat == 6){
                    tituloEjercicio.setText(espaldaHombros[numEjercicio][0]);
                    descripcion.setText(espaldaHombros[numEjercicio][1]);
                    numEjercicio++;
                }
                else if(valueCat == 7 || valueCat == 8 || valueCat == 9){
                    tituloEjercicio.setText(espaldaHombros[numEjercicio][0]);
                    descripcion.setText(espaldaHombros[numEjercicio][1]);
                    numEjercicio++;
                }
                else if(valueCat == 10 || valueCat == 11 || valueCat == 12){
                    tituloEjercicio.setText(espaldaHombros[numEjercicio][0]);
                    descripcion.setText(espaldaHombros[numEjercicio][1]);
                    numEjercicio++;
                }
                else if(valueCat == 13 || valueCat == 14 || valueCat == 15){
                    tituloEjercicio.setText(espaldaHombros[numEjercicio][0]);
                    descripcion.setText(espaldaHombros[numEjercicio][1]);
                    numEjercicio++;
                }
            }
        });


    }
}