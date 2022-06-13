package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entrenamientofisico.db.dbHelper;


public class MainActivity extends AppCompatActivity {

    private TextView fraseRandom;
    private RadioGroup grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_EntrenamientoFisico);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Genera una frase aleatoria cada que se ejecute la aplicacion

        fraseRandom = (TextView) findViewById(R.id.fraseRandom);

        String frasesRandom[] = {
                "La fuerza no viene de una capacidad física. Viene de una voluntad indomable.-Mahatma Gandhi.",
                "Cuando se tiene algo que demostrar, no hay nada mejor que un reto.- Terry Bradshaw.",
                "La vida es demasiado corta para rencores a largo plazo. -Elon Musk.",
                "Si quieres verme conseguir algo, dime que no puedo hacerlo.-Maya Angelou.",
                "No eres un perdedor hasta que no dejas de intentarlo.-Mike Ditka.",
                "Incluso si caes de cara, sigues moviéndote hacia adelante.- Viktor Kiam",
                "La disiplina te llevara a lugares que la motivacion no puede. -Daniel Habif.",
                "Para ser el mejor entrena como si fueses el mejor. -Anonimo.",
                "Para tener éxito, en primer lugar debemos creer que podemos.- Nikos Kazantzakis.",
                "Tienes que esperar cosas de ti mismo antes de poder hacerlas.-Michael Jordan.",
                "No puedes poner un límite a nada. Cuanto más sueñas, más lejos llegas.-Michael Phelps.",
                "Las grandes recompensas esperan a los que son capaces de sufrir, arriesgarse, hacer cosas distintas. Por eso están destinadas a solo unos pocos. -Anónimo.",
                "La motivación es lo que te pone en marcha, y el hábito es lo que hace que sigas.-.Jim Ryun.",
                "El hombre que mueve montañas comienza levantando piedras. -Anonimo.",
                "Lo que encaramos parece insuperable, pero somos mas fuertes de lo que creemos. -Arnold Schwarzenegger.",
                "Da siempre lo mejor de ti. Lo que siembres hoy dará su fruto mañana.-Og Mandino",
                "Un campeón es alguien que se levanta cuando no puede más.-William Harrison “Jack” Dempsey.",
                "Establece tu metas altas, y no pares hasta que no llegues allí.-Bo Jackson.",
                "Creo que es posible para la gente normal elegir ser extraordinaria. -Elon Musk",
                "Seeña sin miedos, entrena sin limites. -Anonimo.",
                "Cuando sietas que vas a rendirte, pienza en por que empezaste. -Anonimo.",
                "No puedes crecer y estar en tu zona de confort. -Anonimo.",
                "Si no puedes volar. corre.\nSi no puedes correr. camina.\nSi no puedes caminar. gatea.\nPero agas lo que agas sigue adelante. -Anonimo.",
                "No se puede ganar a la persona que nunca se rinde.-Babe Ruth.",
                "La persistencia es muy importante. No debes rendirte a menos que estes obligado a rendirte. -Elon Musk",
                "Tarde o temprano la disiplpina vencera a la inteligencia. -Yokoi Kenji.",
                "La falta de actividad destruye la buena condicion de cualquier ser humano, mientras que el movimiento y el ejercicio físico metodico la guardan y la preservan. -Platón.",
                "No te vallas dejando algo sin terminar. -Arnold Schawarzeneger.",
                "La libertad está en ser dueños de la propia vida. -PLATÓN.",
                "El cuerpo está destinado a ser visto, no a estar todo cubierto. -Marilyn Monroe.",
                "Te estas distrayendo, recuerda tu proposito o seras uno mas en el rebaño. -Anonimo.",
        };

        for (int i = 0; i < frasesRandom.length; i++) {
            int index = (int)(Math.random() * frasesRandom.length);
            fraseRandom.setText(frasesRandom[index]);
        }

        grupo = (RadioGroup) findViewById(R.id.categorias);
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
}